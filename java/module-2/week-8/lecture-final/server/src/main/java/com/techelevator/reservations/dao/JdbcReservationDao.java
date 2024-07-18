package com.techelevator.reservations.dao;


import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.model.Reservation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReservationDao implements ReservationDao {
    private JdbcTemplate jdbcTemplate;
    private HotelDao hotelDao;

    private List<Reservation> reservations = new ArrayList<>();

    public JdbcReservationDao(HotelDao hotelDao, JdbcTemplate jdbcTemplate) {
        this.hotelDao = hotelDao;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT reservation_id, hotel_id, full_name, checkin_date, checkout_date, guests " +
                "FROM reservation ;" ;
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                reservations.add(mapRowToReservation(results));
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch(Exception e){
            throw new DaoException("testing 123");
        }
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByHotel(int hotelID)  {
        List<Reservation> hotelReservations = new ArrayList<>();

        String sql = "SELECT reservation_id, hotel_id, full_name, checkin_date, checkout_date, guests " +
                "FROM reservation " +
                "WHERE hotel_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hotelID);
            while (results.next()) {
                hotelReservations.add(mapRowToReservation(results));

            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return hotelReservations;
    }

    @Override
    public Reservation getReservationById(int reservationID) {
        Reservation reservation = null;

        String sql = "SELECT reservation_id, hotel_id, full_name, checkin_date, checkout_date, guests " +
                "FROM reservation " +
                "WHERE reservation_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationID);
            if (results.next()) {
                reservation = (mapRowToReservation(results));

            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reservation;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Integer reservationID;
        String sql = "INSERT INTO reservation (hotel_id, full_name, checkin_date, checkout_date, guests) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id;";  //RETURNING reservation_id;
        try {
            reservationID = jdbcTemplate.queryForObject(sql, Integer.class,
                    reservation.getHotelId(), reservation.getFullName(), reservation.getCheckinDate(), reservation.getCheckoutDate(), reservation.getGuests());
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return getReservationById(reservationID);
    }

    @Override
    public Reservation updateReservation(Reservation reservation)  {
        Reservation updatedReservation = null;
        String sql = "UPDATE reservation " +
                "SET hotel_id = ?, full_name = ?, checkin_date = ?, checkout_date = ?, guests = ?" +
                "WHERE reservation_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, reservation.getHotelId(), reservation.getFullName(), reservation.getCheckinDate(),
                    reservation.getCheckoutDate(), reservation.getGuests(), reservation.getId());
            if(rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            }else{
                updatedReservation = getReservationById(reservation.getId());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedReservation;

    }

    @Override
    public int deleteReservationById(int id)  {
        int rowsAffected;
        String sql = "DELETE FROM reservation WHERE reservation_id = ?;";
        try {
            rowsAffected = jdbcTemplate.update(sql, id);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }



    private Reservation mapRowToReservation(SqlRowSet rs) {
        //Create by passing values in the constructor; could also use create an empty reservation and then use the setters if there is a default constructor;

            Reservation reservation = new Reservation(
                    rs.getInt("reservation_id")
                    , rs.getInt("hotel_id")
                    , rs.getString("full_Name")
                    , rs.getString("checkin_date")
                    , rs.getString("checkout_date")
                    , rs.getInt("guests"));

        return reservation;
    }
}


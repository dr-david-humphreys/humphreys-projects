package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.model.Reservation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReservationDao implements ReservationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservation ORDER BY hotel_id, checkin_date, checkout_date";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Reservation item = mapRowToReservation(results);
                list.add(item);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return list;
    }

    @Override
    public List<Reservation> getReservationsByHotelId(int hotelId) {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservation WHERE hotel_id = ? ORDER BY checkin_date, checkout_date";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hotelId);
            while (results.next()) {
                Reservation item = mapRowToReservation(results);
                list.add(item);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return list;
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        String sql = "SELECT * FROM reservation WHERE reservation_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationId);
            if (results.next()) {
                reservation = mapRowToReservation(results);
            }
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reservation;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        Reservation newReservation = null;
        String sql = "INSERT INTO reservation (hotel_id, full_name, checkin_date, checkout_date, guests) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id";
        try {
            int newId = jdbcTemplate.queryForObject(sql, int.class,
                    reservation.getHotelId(), reservation.getFullName(), reservation.getCheckinDate(),
                    reservation.getCheckoutDate(), reservation.getGuests());
            newReservation = getReservationById(newId);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newReservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation newReservation = null;
        String sql = "UPDATE reservation SET full_name = ?, checkin_date = ?, checkout_date = ?, guests = ? " +
                "WHERE reservation_id = ?";
        try {
            int rowsAffected = jdbcTemplate.update(sql, reservation.getFullName(), reservation.getCheckinDate(),
                    reservation.getCheckoutDate(), reservation.getGuests(), reservation.getHotelId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
            newReservation = getReservationById(reservation.getHotelId());
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newReservation;
    }

    @Override
    public int deleteReservationById(int id) {
        int numberOfRows = 0;
        String sql = "DELETE FROM reservation WHERE reservation_id = ?";
        try {
            numberOfRows = jdbcTemplate.update(sql, id);
        }
        catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numberOfRows;
    }

    private Reservation mapRowToReservation(SqlRowSet rs) {
        Reservation item = new Reservation();
        item.setId(rs.getInt("reservation_id"));
        item.setHotelId(rs.getInt("hotel_id"));
        item.setFullName(rs.getString("full_name"));
        item.setCheckinDate(rs.getDate("checkin_date").toLocalDate());
        item.setCheckoutDate(rs.getDate("checkout_date").toLocalDate());
        item.setGuests(rs.getInt("guests"));
        return item;
    }
}

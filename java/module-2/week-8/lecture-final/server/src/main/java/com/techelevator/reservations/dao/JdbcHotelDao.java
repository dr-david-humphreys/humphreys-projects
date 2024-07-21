package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.model.Address;
import com.techelevator.reservations.model.Hotel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHotelDao implements HotelDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcHotelDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hotel getHotelById(int id) {
        Hotel hotel = null;
        String sql = "SELECT h.hotel_id, h.name, h.stars, h.rooms_available, h.cover_image, h.cost_per_night, " +
                "a.address_id, a.address, a.address2, a.city, a.state, a.zip " +
                "FROM hotel h " +
                "JOIN address a ON h.address_id = a.address_id " +
                "WHERE h.hotel_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                hotel = mapRowToHotel(results);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return hotel;
    }

    @Override
    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT h.hotel_id, h.name, h.stars, h.rooms_available, h.cover_image, h.cost_per_night, " +
                "a.address_id, a.address, a.address2, a.city, a.state, a.zip " +
                "FROM hotel h " +
                "INNER JOIN address a ON h.address_id = a.address_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Hotel hotel = mapRowToHotel(results);
                hotels.add(hotel);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return hotels;

    }

    @Override
    public List<Hotel> getHotelsByStateAndCity(String state, String city) {
        final String SQL_WHERE_CITY_STATE = "WHERE a.city = ? AND a.state = ?;";
        final String SQL_WHERE_CITY = "WHERE a.city = ?;";
        final String SQL_WHERE_STATE = "WHERE a.state = ?;";
        List<Hotel> hotels = new ArrayList<>();
        SqlRowSet results = null;
        String sql = "SELECT h.hotel_id, h.name, h.stars, h.rooms_available, h.cover_image, h.cost_per_night, " +
                "a.address_id, a.address, a.address2, a.city, a.state, a.zip " +
                "FROM hotel h " +
                "JOIN address a ON a.hotel_id = a.hotel_id ";
        try {

            if (state != null && !state.isEmpty() && city != null && !city.isEmpty()) {
                sql += SQL_WHERE_CITY_STATE;
                results = jdbcTemplate.queryForRowSet(sql, state, city);
            } else if (state != null && !state.isEmpty()) {
                sql += SQL_WHERE_STATE;
                results = jdbcTemplate.queryForRowSet(sql, state);
            } else if (city != null && !city.isEmpty()) {
                sql += SQL_WHERE_CITY;
                results = jdbcTemplate.queryForRowSet(sql, city);
            } else {
                results = jdbcTemplate.queryForRowSet(sql);
            }

            while (results.next()) {
                Hotel hotel = mapRowToHotel(results);
                hotels.add(hotel);
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return hotels;

    }

    @Transactional
    @Override
    public Hotel createHotel(Hotel hotel) {
        Integer newHotelId;
        Integer addressId;
        try {

            String sql = "INSERT INTO address (address, address2, city, state, zip, hotel_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING address_id;";
            addressId = jdbcTemplate.update(sql, hotel.getAddress().getAddress(),
                    hotel.getAddress().getAddress2(), hotel.getAddress().getCity(),
                    hotel.getAddress().getState(), hotel.getAddress().getZip());

             sql = "INSERT INTO hotel (name, stars, rooms_available, cost_per_night, cover_image, address_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING hotel_id;";

            newHotelId = jdbcTemplate.queryForObject(sql, Integer.class, hotel.getName(), hotel.getStars(), hotel.getRoomsAvailable(), hotel.getCostPerNight(), hotel.getCoverImage(), addressId);


        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return getHotelById(newHotelId);
    }



    private Hotel mapRowToHotel(SqlRowSet rs) {

        //create Hotel
        Hotel hotel = new Hotel(rs.getInt("hotel_Id"), rs.getString("name"), new Address(), rs.getInt("stars"),
                rs.getInt("rooms_available"), rs.getDouble("cost_per_night"), rs.getString("cover_image"));


        Address address = new Address();

        address.setId(rs.getString("address_id"));
        address.setAddress(rs.getString("address"));
        address.setAddress2(rs.getString("address2"));
        address.setCity(rs.getString("city"));
        address.setState(rs.getString("state"));
        address.setZip(rs.getString("zip"));

        hotel.setAddress(address);

        return hotel;
    }
}

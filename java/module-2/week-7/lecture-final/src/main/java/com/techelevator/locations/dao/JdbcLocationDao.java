package com.techelevator.locations.dao;

import com.techelevator.locations.model.Location;
import com.techelevator.locations.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
//@Component
public class JdbcLocationDao implements LocationDao {

    //@Autowired
    private JdbcTemplate jdbcTemplate;


    public JdbcLocationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Location> getLocations() {
        String sql = "SELECT id, name, address, city, state, zip FROM location";
        try{
            List<Location> locations = jdbcTemplate.query(sql, new LocationRowMapper());
            return locations;
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

    }

    @Override
    public Location getLocationById(int id) {
        String sql = "SELECT id, name, address, city, state, zip FROM location WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new LocationRowMapper());
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

    }

    @Override
    public Location createLocation(Location location) {
        Location createdLocation = null;
        String sql = "INSERT INTO location (name, address, city, state, zip) VALUES (?, ?, ?, ?, ?) RETURNING id";
        try{
            int newId = jdbcTemplate.queryForObject(sql,Integer.class, location.getName(), location.getAddress(), location.getCity(), location.getState(), location.getZip());
            createdLocation =  getLocationById(newId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return createdLocation;
    }

    @Override
    public Location updateLocation(Location location) {
        Location updatedLocation = null;
        String sql = "UPDATE locations SET name = ?, address = ?, city = ?, state = ?, zip = ? WHERE id = ?";
        try {
            int rowsAffected =  jdbcTemplate.update(sql, location.getName(), location.getAddress(), location.getCity(), location.getState(),
                location.getZip(), location.getId());
            if(rowsAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            }else{
                updatedLocation = getLocationById(location.getId());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedLocation;
    }


    @Override
    public int deleteLocationById(int id) {
        int rowsAffected;
        String sql = "DELETE FROM locations WHERE id = ?";
        try{
            rowsAffected = jdbcTemplate.update(sql, id);

        }catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
    }


    //RowMapper Class
    //Nested or Inner Class (avoid multiple top level classes in the same file).
    // For larger, more complex apps or when RowMapper spans implementations, consider separating into its own class for
    // reusability, separation of concerns, readability.
    private static final class LocationRowMapper implements RowMapper<Location> {
        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setId(rs.getInt("id"));
            location.setName(rs.getString("name"));
            location.setAddress(rs.getString("address"));
            location.setCity(rs.getString("city"));
            location.setState(rs.getString("state"));
            location.setZip(rs.getString("zip"));

            return location;
        }
    }
}

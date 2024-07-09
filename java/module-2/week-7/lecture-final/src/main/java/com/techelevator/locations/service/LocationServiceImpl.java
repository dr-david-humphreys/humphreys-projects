package com.techelevator.locations.service;

import com.techelevator.locations.dao.LocationDao;
import com.techelevator.locations.exception.DaoException;
import com.techelevator.locations.exception.ServiceException;
import com.techelevator.locations.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    private LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public List<Location> getLocations() {
        try {
            return locationDao.getLocations();
        }catch (DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Location getLocationById(int id) {
        try {
            Location location = locationDao.getLocationById(id);
            if (location == null) {
                throw new ServiceException("Location id: " + id + " was not found.");
            } else {
                return location;
            }
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Location createLocation(Location location) {
        try {
            return locationDao.createLocation(location);
        }catch (DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public Location updateLocation(Location location) {
        try {
            Location updatedLocation = locationDao.updateLocation(location);
            return updatedLocation;
        } catch (DaoException e) {
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    @Override
    public int deleteLocationById(int id) {
        int rowsAffected = 0;
        try {
            rowsAffected = locationDao.deleteLocationById(id);
            return rowsAffected;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }


}

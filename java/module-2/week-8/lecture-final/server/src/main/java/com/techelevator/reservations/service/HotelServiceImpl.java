package com.techelevator.reservations.service;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.JdbcHotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.exception.ServiceException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelServiceImpl(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    public List<Hotel> getHotelsByStateAndCity(String state, String city) {
        //Business logic like the following should be in the service layer and not the controller.
        try {
            List<Hotel> hotelList = new ArrayList<>();
            if ((state != null && !state.isEmpty()) || (city != null && !city.isEmpty())) {
                hotelList = hotelDao.getHotelsByStateAndCity(state, city);
            } else {
                hotelList = hotelDao.getHotels();
            }
            return hotelList;
        }catch (DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    public Hotel getHotelById(int id) {
        try {
            Hotel hotel = hotelDao.getHotelById(id);
            // Make to hotels.com API to get information
            // CALL ACCOUNTING PRICING ALGORITHM TO CALCULATE FEES
            if (hotel == null) {
                throw new ServiceException("Hotel id " + id + " was not found.");
            } else {
                return hotel;
            }
        }
        catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param hotel
     */
    public Hotel addHotel(Hotel hotel) {
        try {
            Hotel createdHotel = new Hotel();
            createdHotel = hotelDao.createHotel(createdHotel);
            return createdHotel;
        }
        catch (DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    public List<Reservation> getReservations() {
        try{
            List<Reservation> reservations = reservationDao.getReservations();
            return reservations;
        }catch(DaoException e) {
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }

    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    public Reservation getReservationById(int id) {
        try{
            Reservation reservation = reservationDao.getReservationById(id);
            return reservation;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }

    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */
    public List<Reservation> getReservationsByHotel(int hotelId) {
        try {
            List<Reservation> reservations = reservationDao.getReservationsByHotel(hotelId);
            return reservations;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }

    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    public Reservation createReservation(Reservation reservation) {

        try {
            Reservation newReservation = reservationDao.createReservation(reservation);
            return newReservation;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }
    }

    /**
     * Updates a reservation
     *
     * @param reservation
     * @return the updated Reservation
     */
    public Reservation updateReservation(@Valid Reservation reservation) {
        try {
            Reservation updatedReservation = reservationDao.updateReservation(reservation);
            return updatedReservation;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }


    }

    /**
     * Delete a reservation by id
     *
     * @param id
     */
    public boolean deleteReservation(int id) {
        boolean success;
        try{
            reservationDao.deleteReservationById(id);
            success = true;
        }catch(DaoException e){
            //Call logger to capture and log specific exception details per business/error handling rules - e.getMessage(), e, etc...
            throw new ServiceException("An error has occurred: " + e.getMessage());
        }

        return success;

    }

    /**
     * Used to log operations
     * @param operation
     * @param reservation
     * @param username
     */
    private void auditLog(String operation, int reservation, String username) {
        System.out.println("User: " + username + " performed the operation: " + operation + " on reservation: " + reservation);
    }
}

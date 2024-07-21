package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.exception.DaoException;
import com.techelevator.reservations.exception.ServiceException;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import com.techelevator.reservations.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@PreAuthorize("isAuthenticated()")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @PreAuthorize("permitAll")
    @GetMapping("/hotels")
    public List<Hotel> list(@RequestParam(required=false) String state, @RequestParam(required = false) String city) {
        try {
            List<Hotel> hotels = hotelService.getHotelsByStateAndCity(state, city);
            return hotels;
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }

    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @GetMapping("/hotels/{id}")
    public Hotel get(@PathVariable int id) {
        if(id <=0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client side error - make sure your request properly defined.");
        }
        try {
            Hotel hotel = hotelService.getHotelById(id);
            if (hotel == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client side error - make sure your request properly defined.");
            } else {
                return hotel;
            }
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @PreAuthorize("hasAnyRole('ADMIN', 'MGR', 'USER')")
    @GetMapping("/reservations")
    public List<Reservation> listReservations() {
        try {
            List<Reservation> reservations = hotelService.getReservations();
            return reservations;

        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }

    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable int id) {
        if(id <=0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client side error - make sure your request is properly defined.");
        }
        try {
            Reservation reservation = hotelService.getReservationById(id);
            if (reservation == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client side error - make sure your request is properly defined.");
            } else {
                return reservation;
            }
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */
    @GetMapping("/hotels/{id}/reservations")
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
        if(hotelId <=0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client side error - make sure your request is properly defined.");
        }
        try {
            List<Reservation> reservations = hotelService.getReservationsByHotel(hotelId);
            if (reservations == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client side error - make sure your request is properly defined.");
            } else {
                return reservations;
            }
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }



    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reservations")
    public ResponseEntity<Reservation> addReservation(@Valid @RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = hotelService.createReservation(reservation);
            if (createdReservation == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
            } else {
                return ResponseEntity.ok(createdReservation);
            }
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }
    }



    /**
     * Updates a reservation
     *
     * @param reservation
     * @param id
     * @return the updated Reservation
     */
    @PutMapping("/reservations/{id}")
    public Reservation update(@Valid @RequestBody Reservation reservation, @PathVariable int id) {
        if(id <=0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client side error - make sure your request is properly defined.");
        }
        // The id on the path takes precedence over the one in the request body, if any
        reservation.setId(id);
        try {
            Reservation updatedReservation = hotelService.updateReservation(reservation);
            if (updatedReservation == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
            } else {
                return updatedReservation;
            }
        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }

    }

    /**
     * Delete a reservation by id
     *
     * @param id
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/reservations/{id}")
    public void delete(@PathVariable int id, Principal principal) {
        try {
            auditLog("delete", id, principal.getName());
            hotelService.deleteReservation(id);
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Used to log operations
     * @param operation
     * @param reservationId
     * @param username
     */
    //@PreAuthorize("hasRole('ADMIN')")
    private void auditLog(String operation, int reservationId, String username) {
        System.out.println(
                "User: " + username + " performed the operation: " + operation + " on reservation: " + reservationId);
    }


}

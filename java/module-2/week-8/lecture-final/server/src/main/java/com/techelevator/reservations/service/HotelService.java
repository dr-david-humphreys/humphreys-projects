package com.techelevator.reservations.service;

import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;

import java.security.Principal;
import java.util.List;

public interface HotelService {

    public List<Hotel> getHotelsByStateAndCity(String state, String city);
    public Hotel getHotelById(int id);
    public Hotel addHotel(Hotel hotel);
    public List<Reservation> getReservations();
    public Reservation getReservationById(int id);
    public List<Reservation> getReservationsByHotel(int hotelId);
    public Reservation createReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public boolean deleteReservation(int id);


}

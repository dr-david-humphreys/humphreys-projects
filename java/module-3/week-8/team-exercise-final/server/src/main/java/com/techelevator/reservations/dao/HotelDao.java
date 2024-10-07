package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getHotelsByOptionalStateAndOrCity(String state, String city);

    Hotel getHotelById(int id);

    List<String> getStates();

}

package com.techelevator.locations.service;

import com.techelevator.locations.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> getLocations();

    Location getLocationById(int id);

    Location createLocation(Location location);

    Location updateLocation(Location location);

    int deleteLocationById(int id);

}

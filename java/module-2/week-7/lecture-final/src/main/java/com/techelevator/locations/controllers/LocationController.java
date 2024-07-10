package com.techelevator.locations.controllers;

import com.techelevator.locations.dao.LocationDao;
import com.techelevator.locations.exception.DaoException;
import com.techelevator.locations.exception.ServiceException;
import com.techelevator.locations.model.Location;
import com.techelevator.locations.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {


    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    //@RequestMapping(path = "", method = RequestMethod.GET)
    @GetMapping("")
    public List<Location> list() {
        List<Location> locations = locationService.getLocations();
        if(locations != null && locations.size() > 0){
            return locations;
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered.");
        }

    }

    //@RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Location get(@PathVariable int id) {
        Location location = locationService.getLocationById(id);
        if (location == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found");
        } else {
            return location;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(path = "", method = RequestMethod.POST)
    @PostMapping("")
    public Location add(@Valid @RequestBody Location location) {
        try{
            Location createdLocation = locationService.createLocation(location);
            return location;

        }catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error encountered: " + e.getMessage());
        }

    }



    //@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public Location update(@Valid @RequestBody Location location, @PathVariable int id) {
        // The id on the path takes precedence over the id in the request body, if any
        location.setId(id);
        try {
            Location updatedLocation = locationService.updateLocation(location);
            return updatedLocation;
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue updating location: " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    //@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        try{
            locationService.deleteLocationById(id);
        } catch(ServiceException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong..." + e.getMessage());
        }

    }

}

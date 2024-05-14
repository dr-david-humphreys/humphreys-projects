package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */

   // Attributes

    private String name;
    private boolean open;
    private final int numberOfCompactSlots;
    private final int numberOfMidsizeSlots;
    private final int numberOfFullsizeSlots;
    private List<Car> compactSlots;
    private List<Car> midsizeSlots;
    private List<Car> fullsizeSlots;



    // Constructors

    public ParkingLot(String name) {
        this(name, false);
    }

    public ParkingLot(String name, boolean open) {
        this(name, open, DEFAULT_NUMBER_OF_COMPACT_SLOTS, DEFAULT_NUMBER_OF_MIDSIZE_SLOTS, DEFAULT_NUMBER_OF_FULLSIZE_SLOTS);
    }
    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
        this.compactSlots = new ArrayList<>();
        this.midsizeSlots = new ArrayList<>();
        this.fullsizeSlots = new ArrayList<>();
    }

    // Getters

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public int getDefaultNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getDefaultNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getDefaultNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    // Setters

    public void setOpen(boolean open) {
        this.open = open;
    }


    // Public Methods

    public int numberOfAvailableSlots(String carType) {
        if (carType.equalsIgnoreCase("compact")) {
            return numberOfCompactSlots - compactSlots.size();
        } else if (carType.equalsIgnoreCase("midsize")) {
            return numberOfMidsizeSlots - midsizeSlots.size();
        } else if (carType.equalsIgnoreCase("fullsize")) {
            return numberOfFullsizeSlots - fullsizeSlots.size();
        } else {
            return 0;
        }
    }

    public boolean park(Car car) throws ParkingLotException {
        if (!open) {
            throw new ParkingLotException("Parking lot is full");
        }

        if (car.getType().equalsIgnoreCase("compact")) {
            if (compactSlots.size() < numberOfCompactSlots) {
                compactSlots.add(car);
                return true;
            }
        } else if (car.getType().equalsIgnoreCase("midsize")) {
            if (midsizeSlots.size() < numberOfMidsizeSlots) {
                midsizeSlots.add(car);
                return true;
            }
        } else if (car.getType().equalsIgnoreCase("fullsize")) {
            if (fullsizeSlots.size() < numberOfFullsizeSlots) {
                fullsizeSlots.add(car);
                return true;
            }
        }
        return false;
    }

    public Car exit(String license) {
        for (Car car : compactSlots) {
            if (car.getLicense().equals(license)) {
                compactSlots.remove(car);
                return car;
            }
        }

        for (Car car : midsizeSlots) {
            if (car.getLicense().equals(license)) {
                midsizeSlots.remove(car);
                return car;
            }
        }

        for (Car car : fullsizeSlots) {
            if (car.getLicense().equals(license)) {
                fullsizeSlots.remove(car);
                return car;
            }
        }

        return null;
    }
}

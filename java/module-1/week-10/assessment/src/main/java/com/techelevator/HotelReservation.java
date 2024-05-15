package com.techelevator;

public class HotelReservation {
    private String name;
    private int numberOfNights;
    private int nightlyRate;

    //Constructor
    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    //Derived attribute estimatedTotal
    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }

    //Method for calculating actual total
    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        int actualTotal = getEstimatedTotal();
        if (requiresCleaning) {
            actualTotal += 25;
        }

        if (usedMinibar) {
            actualTotal += 15;
            if (requiresCleaning) {
                actualTotal += 25;
            }
        }
        return actualTotal;
    }

    //Override toString method
    public String toString() {
        return name + ":" + getEstimatedTotal();
    }
}

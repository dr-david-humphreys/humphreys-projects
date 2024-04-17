package com.techelevator.farm;

public class Tractor implements Singable{

    private String name;
    private String sound;
    public Tractor(){
        this.name = "Tractor";
        this.sound= "vroom!";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound(){
        return sound;
    }
}

package com.techelevator.farm;

import java.util.Objects;

public class Tractor implements Singable{

    private String name;
    private String sound;
    public Tractor(){
        this.name = "Tractor";
        this.sound= "vroom!";
    }

    public Tractor(String name, String sound){
        this.name = name;
        this.sound= sound;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound(){
        return sound;
    }


    @Override
    public String toString(){
        int year = 2024;
        String tractorText = String.format("Tractor: %s-(%s) Year: %d", name, sound, year );
        return tractorText;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tractor tractor = (Tractor) o;
        return name.equals(tractor.name) && sound.equals(tractor.sound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sound);
    }


}

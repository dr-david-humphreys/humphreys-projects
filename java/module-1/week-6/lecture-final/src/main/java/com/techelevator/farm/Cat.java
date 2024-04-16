package com.techelevator.farm;

public final class Cat extends FarmAnimal {

    public Cat(){
        super("Cat", "meow!");
    }

    public Cat(String name, String sound){
        super(name, sound);
    }

    @Override
    public String eat(){
        return "Eating cat food...";
    }

    //Cant override because getSound() is marked final
//    @Override
//    public String getSound(){
//        return "MEOW!!!";
//    }
}

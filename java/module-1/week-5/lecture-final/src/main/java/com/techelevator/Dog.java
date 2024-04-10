package com.techelevator;

public class Dog {

    //Class variables - static
    public static final String ANCESTOR = "Wolf";


    //Instance variables/properties
    private String name;
    private String breed;
    private int age;


    //Constructor
    public Dog(){
    }

    public Dog(String name, String breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;

    }

    //Getters and Setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBreed(){
        return breed;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        if(age > 0 && age < 26 ){
             this.age = age;
        }else{
            this.age = 1;
        }
    }


    //custom method
    public String bark(){
        return this.name + " Says woof...woof!";
    }

}

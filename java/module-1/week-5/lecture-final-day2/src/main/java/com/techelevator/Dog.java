package com.techelevator;

public class Dog {

    //Class variables - static
    public static final String ANCESTOR = "Wolf";


    //Instance variables/properties
    private String name;
    private String breed;
    private int age = 1;



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

    //derived property
    //Using Java Docs comments to provide documentation for the getAgeInDogYears method
    /**
     * Calculates standard ag into dog years age.
     * @return calculated dog years.
     */
    public int getAgeInDogYears(){
        return this.age * 7;
    }

    //Using Java Docs comments to provide documentation for the getAgeInDogYears method
    /**
     * Calculates standard age into dog years age.
     * @param multiplier years factor to determine age.
     * @return calculated dog years.
     */
    // Using method overloading to provide flexibility using the getAgeInDogYears method.
    public int getAgeInDogYears(int multiplier){
        return this.age * 7;
        //TODO: Calculate enhanced age for a dog
    }



    //custom method
    public String bark(){
        return this.name + " Says woof...woof!";
    }

}

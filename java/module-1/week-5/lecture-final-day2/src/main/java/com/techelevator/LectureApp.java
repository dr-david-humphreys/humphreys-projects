package com.techelevator;

public class LectureApp {
    public static void main(String[] args) {
        System.out.println("############################");
        System.out.println("Classes and Encapsulation");
        System.out.println("############################");

        Dog snoopy = new Dog();
        Dog giselle = new Dog("Giselle", "Cockapoodle", 10);


        snoopy.setName("Snoopy");
        snoopy.setBreed("Beagle");
        snoopy.setAge(8);

        System.out.println("Giselle is:" + giselle.getAge() + " years old");
        System.out.println("Snoopy is:" + snoopy.getAge() + " years old");
        //TODO: Create a list of dogs
        System.out.println(giselle.bark());
        System.out.println(snoopy.bark());

        System.out.println("The ancestor of Giselle and Snoopy and all instances of Dog is the: " + Dog.ANCESTOR);

        //TODO: Print out the full description of each dog
        System.out.println(giselle.getName() + " is " +giselle.getAgeInDogYears(8) + " in dog years");


    }
}
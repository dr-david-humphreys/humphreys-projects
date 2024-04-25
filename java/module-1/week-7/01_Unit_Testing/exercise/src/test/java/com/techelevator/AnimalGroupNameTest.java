package com.techelevator;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalGroupNameTest {
    @Test
    public void get_herd_returns_correct_name() {
        AnimalGroupName animalGroupName = new AnimalGroupName();

        assertEquals("Crash", animalGroupName.getHerd("Rhino"));
        assertEquals("Tower", animalGroupName.getHerd("Giraffe"));
        assertEquals("Herd", animalGroupName.getHerd("Elephant"));
        assertEquals("Pride", animalGroupName.getHerd("Lion"));
        assertEquals("Murder", animalGroupName.getHerd("Crow"));
        assertEquals("Kit", animalGroupName.getHerd("Pigeon"));
        assertEquals("Pat", animalGroupName.getHerd("Flamingo"));
        assertEquals("Herd", animalGroupName.getHerd("Deer"));
        assertEquals("Pack", animalGroupName.getHerd("Dog"));
        assertEquals("Float", animalGroupName.getHerd("Crocodile"));

        assertEquals("unknown", animalGroupName.getHerd(""));
        assertEquals("unknown", animalGroupName.getHerd("walrus"));
        assertEquals("unknown", animalGroupName.getHerd("elephants"));
    }
}

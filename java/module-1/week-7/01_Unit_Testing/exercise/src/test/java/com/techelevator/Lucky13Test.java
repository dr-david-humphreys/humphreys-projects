package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {

    private Lucky13 lucky13;

    @Before
    public void setUp() {
        lucky13 = new Lucky13();
    }

    @Test
    public void contains_no_ones_or_threes() {
        assertTrue(lucky13.getLucky(new int[]{0, 2, 4}));
        assertTrue(lucky13.getLucky(new int[]{0, 9, 2}));
    }

    @Test
    public void contains_ones_no_threes() {
        assertFalse(lucky13.getLucky(new int[]{1, 2, 4}));
    }

    @Test
    public void contains_threes_no_ones() {
        assertFalse(lucky13.getLucky(new int[]{0, 2, 3}));
    }

    @Test
    public void contains_ones_and_threes() {
        assertFalse(lucky13.getLucky(new int[]{1, 2, 3}));
    }
}

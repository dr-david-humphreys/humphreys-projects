package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {

    private SameFirstLast sameFirstLast;

    @Before
    public void setUp() {
        sameFirstLast = new SameFirstLast();
    }

    @Test
    public void first_and_last_are_equal() {
        assertTrue(sameFirstLast.isItTheSame(new int[]{1, 2, 3, 1}));
        assertTrue(sameFirstLast.isItTheSame(new int[]{1, 2, 1}));
    }

    @Test
    public void first_and_last_are_not_equal() {
        assertFalse(sameFirstLast.isItTheSame(new int[]{1, 2, 3}));
    }
}

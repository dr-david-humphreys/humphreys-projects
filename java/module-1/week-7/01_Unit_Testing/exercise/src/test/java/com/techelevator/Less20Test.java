package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {
    private Less20 less20;

    @Before
    public void setUp() {
        less20 = new Less20();
    }

    @Test
    public void is_one_or_two_less_than_multiple_of_twenty() {
        assertTrue(less20.isLessThanMultipleOf20(18));
        assertTrue(less20.isLessThanMultipleOf20(19));
        assertTrue(less20.isLessThanMultipleOf20(39));
    }

    @Test
    public void is_equal_to_multiple_of_twenty() {
        assertFalse(less20.isLessThanMultipleOf20(20));
        assertFalse(less20.isLessThanMultipleOf20(40));
    }

    @Test
    public void is_more_than_one_or_two_less() {
        assertFalse(less20.isLessThanMultipleOf20(5));
        assertFalse(less20.isLessThanMultipleOf20(17));
    }
}

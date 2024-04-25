package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {

    private MaxEnd3 maxEnd3;

    @Before
    public void setUp() {
        maxEnd3 = new MaxEnd3();
    }

    @Test
    public void larger_last_element() {
        assertArrayEquals(new int[]{3, 3, 3}, maxEnd3.makeArray(new int[]{1, 2, 3}));
    }

    @Test
    public void larger_first_element() {
        assertArrayEquals(new int[]{11, 11, 11}, maxEnd3.makeArray(new int[]{11, 5, 9}));
    }

    @Test
    public void larger_middle_element() {
        assertArrayEquals(new int[]{3, 3, 3}, maxEnd3.makeArray(new int[]{2, 11, 3}));
    }


}

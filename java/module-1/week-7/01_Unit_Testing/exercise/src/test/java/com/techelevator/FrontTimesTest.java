package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {
    private FrontTimes frontTimes;

    @Before
    public void setUp() {
        frontTimes = new FrontTimes();
    }

    @Test
    public void generate_correct_string_based_on_integer_number() {
        assertEquals("ChoCho", frontTimes.generateString("Chocolate", 2));
        assertEquals("ChoChoCho", frontTimes.generateString("Chocolate", 3));
        assertEquals("AbcAbcAbc", frontTimes.generateString("Abc", 3));
    }

    @Test
    public void generate_correct_string_for_less_than_three_chars() {
        assertEquals("AbAbAb", frontTimes.generateString("Ab",3));
    }


}

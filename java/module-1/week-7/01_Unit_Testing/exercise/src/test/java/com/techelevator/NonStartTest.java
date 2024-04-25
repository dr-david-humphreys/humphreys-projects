package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {

    private NonStart nonStart;

    @Before
    public void setUp() {
        nonStart = new NonStart();
    }

    @Test
    public void correct_concatenation() {
        assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
        assertEquals("avaode", nonStart.getPartialString("java", "code"));
        assertEquals("hotlava", nonStart.getPartialString("shotl", "java"));
    }
}

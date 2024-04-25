package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {

    private StringBits stringBits;

    @Before
    public void setUp() {
        stringBits = new StringBits();
    }

    @Test
    public void string_bits_returns_correctly() {
        assertEquals("Hlo", stringBits.getBits("Hello"));
        assertEquals("H", stringBits.getBits("Hi"));
        assertEquals("Hello", stringBits.getBits("Heeololeo"));
    }
}

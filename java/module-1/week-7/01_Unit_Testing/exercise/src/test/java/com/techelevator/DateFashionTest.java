package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateFashionTest {

    private DateFashion dateFashion;

    @Before
    public void setUp() {
        dateFashion = new DateFashion();
    }

    @Test
    public void get_table_because_date_is_stylish() {
        assertEquals(2, dateFashion.getATable(5,10));
    }

    @Test
    public void no_table_because_date_is_not_stylish() {
        assertEquals(0, dateFashion.getATable(5,2));
    }

    @Test
    public void maybe_get_a_table_since_both_are_mildly_stylish() {
        assertEquals(1, dateFashion.getATable(5,5));
    }
}

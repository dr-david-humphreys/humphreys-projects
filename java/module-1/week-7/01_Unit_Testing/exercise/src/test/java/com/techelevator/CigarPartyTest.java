package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CigarPartyTest {

    private CigarParty cigarParty;

    @Before
    public void setUp() {
        cigarParty = new CigarParty();
    }

    @Test
    public void weekday_party_less_than_minimum() {
        assertFalse(cigarParty.haveParty(30, false));
    }

    @Test
    public void weekday_party_in_range() {
        assertTrue(cigarParty.haveParty(50, false));
    }

    @Test
    public void weekend_party_over_maximum() {
        assertTrue(cigarParty.haveParty(70, true));
    }
}

package com.thoughtworks.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ChanceTest {


    private Chance chance;

    @Before
    public void setUp() throws Exception {
        chance = new Chance(0.7f);
    }

    @Test
    public void testProbabilityOfEventNOTOccurring() {
        assertEquals(new Chance(0.3f), chance.not());
    }

    @Test
    public void testEquals() {
        assertTrue(chance.equals(new Chance(0.7f)));
    }

    @Test
    public void testNotEquals() {
        assertFalse(chance.equals(new Chance(0.9f)));
    }

    @Test
    public void testProbabilityOfBothEventsOccurring() {
        assertEquals(new Chance(0.14f), chance.and(new Chance(0.2f)));
    }

    @Test
    public void testProbabilityOfEitherEventsOccurring() {
        assertEquals(new Chance(0.76f), chance.or(new Chance(0.2f)));
    }
}
package com.thoughtworks.bootcamp;

import com.thoughtworks.bootcamp.Chance;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ChanceTest {

    Chance chance;

    @Before
    public void setup() {
        chance = new Chance(0.2f);
    }

    @Test
    public void shouldCheckForEquality() {
        assertEquals(chance, new Chance(0.2f));
    }

    @Test
    public void shouldCheckForComplement() {
        assertEquals(new Chance(0.8f), chance.not());
    }

    @Test
    public void shouldCalculateAnd() {
        assertEquals(new Chance(0.08f), chance.and(new Chance(0.4f)));
    }

    @Test
    public void shouldCalculateOr() {
        assertEquals(new Chance(0.52f), chance.or(new Chance(0.4f)));
    }
}

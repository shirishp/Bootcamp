package com.thoughtworks.bootcamp;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class UnitTest {
    @Test
    public void shouldCheckForSameGroup() throws Exception {
         assertTrue(Unit.FEET.isCompatibleWith(Unit.INCH));
         assertFalse(Unit.TBSP.isCompatibleWith(Unit.INCH));
    }
}

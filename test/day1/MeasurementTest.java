package day1;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MeasurementTest {

    @Test
    public void shouldCheckForEquality() {
        assertEquals(new Measurement(12, Unit.INCH), new Measurement(12, Unit.INCH));
        assertEquals(new Measurement(12, Unit.INCH), new Measurement(1, Unit.FEET));
        assertFalse(new Measurement(13, Unit.INCH).equals(new Measurement(1, Unit.FEET)));
    }

    @Test
    public void shouldCheckForEqualityBetweenFeetAndYard() {
        assertEquals(new Measurement(1, Unit.YARD), new Measurement(3, Unit.FEET));
    }

    @Test
    public void shouldCheckForEqualityBetweenMileAndYard() {
        assertEquals(new Measurement(1, Unit.MILE), new Measurement(1760, Unit.YARD));
    }

    @Test
    public void shouldCheckForEqualityBetweenMileAndFeet() {
        assertEquals(new Measurement(1, Unit.MILE), new Measurement(1760 * 3, Unit.FEET));
    }

    @Test
    public void shouldCheckForEqualityTSBst() {
        assertEquals(new Measurement(1, Unit.TBSP), new Measurement(3, Unit.TSP));

    }

    @Test
    public void shouldReturnFalseForIncomparableUnits() {
        assertFalse(new Measurement(1, Unit.INCH).equals(new Measurement(1, Unit.TSP)));
    }

}

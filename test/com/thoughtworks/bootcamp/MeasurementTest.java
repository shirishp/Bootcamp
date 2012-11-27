package com.thoughtworks.bootcamp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MeasurementTest {

    private Measurement getMeasurement(float value, Unit unit) {
        return MeasurementFactory.getMeasurement(value, unit);
    }

    @Test
    public void shouldCheckForEquality() {
        assertEquals(getMeasurement(12, Unit.INCH), getMeasurement(12, Unit.INCH));
        assertEquals(getMeasurement(12, Unit.INCH), getMeasurement(1, Unit.FEET));
        assertFalse(getMeasurement(13, Unit.INCH).equals(getMeasurement(1, Unit.FEET)));
    }

    @Test
    public void shouldCheckForEqualityBetweenFeetAndYard() {
        assertEquals(getMeasurement(1, Unit.YARD), getMeasurement(3, Unit.FEET));
    }

    @Test
    public void shouldCheckForEqualityBetweenMileAndYard() {
        assertEquals(getMeasurement(1, Unit.MILE), getMeasurement(1760, Unit.YARD));
    }

    @Test
    public void shouldCheckForEqualityBetweenMileAndFeet() {
        assertEquals(getMeasurement(1, Unit.MILE), getMeasurement(1760 * 3, Unit.FEET));
    }

    @Test
    public void shouldCheckForEqualityTSBst() {
        assertEquals(getMeasurement(1, Unit.TBSP), getMeasurement(3, Unit.TSP));

    }

    @Test
    public void shouldCheckForTemperatureEquality() {
        assertEquals(new Temperature(0,Unit.CELSIUS), new Temperature(32, Unit.FAHRENHEIT));
        assertEquals(new Temperature(212,Unit.FAHRENHEIT), new Temperature(100, Unit.CELSIUS));
        assertFalse(new Temperature(54,Unit.FAHRENHEIT).equals(new Temperature(10, Unit.CELSIUS)));
        assertFalse(new Temperature(54,Unit.CELSIUS).equals(new Temperature(10, Unit.CELSIUS)));
    }


    @Test
    public void shouldConvertTBSPtoOzs() {
        assertEquals(getMeasurement(1, Unit.OZ), getMeasurement(2, Unit.TBSP));
    }

    @Test
    public void shouldConvertOzToCup() {
        assertEquals(getMeasurement(1, Unit.CUP), getMeasurement(8, Unit.OZ));
    }

    @Test
    public void shouldReturnFalseForIncomparableUnits() {
        assertFalse(getMeasurement(1, Unit.INCH).equals(getMeasurement(1, Unit.TSP)));
    }

    @Test
    public void shouldAddCompatibleUnits() {
        assertEquals(getMeasurement(4, Unit.INCH), ((AddableMeasurement)getMeasurement(2, Unit.INCH)).add(getMeasurement(2, Unit.INCH)));
        assertEquals(getMeasurement(4, Unit.FEET), ((AddableMeasurement)getMeasurement(2, Unit.FEET)).add(getMeasurement(2, Unit.FEET)));
        assertEquals(getMeasurement(27, Unit.INCH), ((AddableMeasurement)getMeasurement(3, Unit.INCH)).add(getMeasurement(2, Unit.FEET)));
        assertEquals(getMeasurement(12, Unit.TSP), ((AddableMeasurement)getMeasurement(2, Unit.TBSP)).add(getMeasurement(1, Unit.OZ)));
    }

    @Test(expected = IncompatibleUnitException.class)
    public void shouldNOTAddIncompatibleUnits() {
        ((AddableMeasurement)getMeasurement(2, Unit.INCH)).add(getMeasurement(1, Unit.OZ));
    }


    @Test
    public void shouldCompareMeasurements() {
        assertEquals(-1, getMeasurement(4, Unit.INCH).compareTo(getMeasurement(3, Unit.INCH)));
        assertEquals(1, getMeasurement(2, Unit.INCH).compareTo(getMeasurement(3, Unit.INCH)));
        assertEquals(0, getMeasurement(2, Unit.INCH).compareTo(getMeasurement(2, Unit.INCH)));
    }

}

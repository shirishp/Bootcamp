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

    @Test
    public void shouldCheckForEqualityBetweenOzAndTBSP(){
        assertEquals(new Measurement(1, Unit.OZ), (new Measurement(2, Unit.TBSP)));
    }

    @Test
    public void shouldCheckForEqualityBetweenCupAndOz(){
        assertEquals(new Measurement(1,Unit.CUP), (new Measurement(8, Unit.OZ)));
    }

    @Test
    public void shouldBeAbleToAdd2MeasurementsOfSameType() {
        Measurement length1 = new Measurement(2,Unit.FEET);
        Measurement length2 = new Measurement(3,Unit.INCH);
        assertEquals(new Measurement(27, Unit.INCH), length1.add(length2));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotAdd2MeasurementsOfDifferentTypes() {
        Measurement firstMeasure = new Measurement(2, Unit.FEET);
        Measurement anotherMeasure = new Measurement(1, Unit.OZ);
        firstMeasure.add(anotherMeasure);
    }
}

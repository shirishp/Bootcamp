package day1;


public class Measurement {

    @Override
    public int hashCode() {
        int result = (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    private final float value;


    private final Unit unit;

    public Measurement(float value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;

        Measurement anotherMeasurement = (Measurement) another;

        if (! this.unit.isCompatible(anotherMeasurement.unit)) {
            return false;
        }

        return nearlyEqual(unit.convertTo(value,anotherMeasurement.unit),anotherMeasurement.value , 0.001f);
    }



    private static boolean nearlyEqual(float a, float b, float epsilon)
    {
        final float absA = Math.abs(a);
        final float absB = Math.abs(b);
        final float diff = Math.abs(a - b);

        if (a == b) { // shortcut, handles infinities
            return true;
        } else if (a * b == 0) { // a or b or both are zero
            // relative error is not meaningful here
            return diff < (epsilon * epsilon);
        } else { // use relative error
            return diff / (absA + absB) < epsilon;
        }
    }


    public Measurement add(Measurement anotherMeasurement) {
        if (! this.unit.isCompatible(anotherMeasurement.unit)) {
            throw new IllegalArgumentException("Incompatible units");
        }

        return new Measurement(value +
                anotherMeasurement.convertTo(this.unit), this.unit);
    }

    private float convertTo(Unit thatUnit){
       return this.unit.convertTo(value,thatUnit);
    }
}

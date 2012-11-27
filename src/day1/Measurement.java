package day1;


public class Measurement {

    private final int value;
    private final Unit unit;

    public Measurement(int value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;

        Measurement anotherMeasurement = (Measurement) another;

        if(!this.unit.isSameGroup(anotherMeasurement.unit)) return false;

        if (this.unit.baseUnits(this.value) != anotherMeasurement.unit.baseUnits(anotherMeasurement.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  value + " " + unit.name();
    }



}

package com.thoughtworks.bootcamp;


public abstract class Measurement{

    protected final float value;
    protected final Unit unit;

    public Measurement(float value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null) return false;

        Measurement anotherMeasurement = (Measurement) another;

        if(!this.unit.isCompatibleWith(anotherMeasurement.unit)) return false;

        if (this.unit.baseUnits(this.value) != anotherMeasurement.unit.baseUnits(anotherMeasurement.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) value;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  value + " " + unit.name();
    }


    protected float convertTo(Unit anotherUnit) {
        return unit.convertTo(value, anotherUnit);
    }

    public int compareTo(Measurement that){
       if ( this.unit.baseUnits(this.value) > that.unit.baseUnits(that.value)) {
           return -1;
       }else if (this.unit.baseUnits(this.value) < that.unit.baseUnits(that.value))  {
           return 1;
       }else {
           return 0;
       }

    }
}

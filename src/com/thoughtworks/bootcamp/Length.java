package com.thoughtworks.bootcamp;

public class Length extends Measurement implements AddableMeasurement {

    protected Length(float value, Unit unit) {
        super(value, unit);
    }

    @Override
    public AddableMeasurement add(Measurement anotherMeasurement) throws IncompatibleUnitException {
        if(!unit.isCompatibleWith(anotherMeasurement.unit)) // FAIL FAST
            throw new IncompatibleUnitException();

        return new Length(value + anotherMeasurement.convertTo(unit), unit);
    }



}

package com.thoughtworks.bootcamp;

public class Volume extends Measurement implements AddableMeasurement{

    protected Volume(float value, Unit unit) {
        super(value, unit);
    }

    @Override
    public AddableMeasurement add(Measurement anotherMeasurement) throws IncompatibleUnitException {
        if(!unit.isCompatibleWith(anotherMeasurement.unit)) // FAIL FAST
            throw new IncompatibleUnitException();

        return new Volume(value + anotherMeasurement.convertTo(unit), unit);
    }

}

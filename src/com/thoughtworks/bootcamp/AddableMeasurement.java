package com.thoughtworks.bootcamp;

public interface AddableMeasurement {

    public AddableMeasurement add(Measurement anotherMeasurement) throws IncompatibleUnitException;
}

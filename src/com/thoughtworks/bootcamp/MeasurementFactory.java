package com.thoughtworks.bootcamp;

public class MeasurementFactory {

    private MeasurementFactory(){

    }

    public static Measurement getMeasurement(float value, Unit unit){
        switch(unit.getMeasurementType()){
            case LENGTH: return new Length(value, unit);
            case VOLUME: return new Volume(value, unit);
            case TEMPERATURE: return new Temperature(value, unit);
        }
        return null;
    }
}

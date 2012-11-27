package com.thoughtworks.bootcamp;


public enum Unit {
    FEET(MeasurementType.LENGTH) {
        @Override
        public float baseUnits(float value) {
            return FEET_TO_INCHES * value;
        }
    },
    INCH(MeasurementType.LENGTH) {
        @Override
        public float baseUnits(float value) {
            return value;
        }
    },
    YARD(MeasurementType.LENGTH) {
        @Override
        public float baseUnits(float value) {
            return YARD_TO_INCHES * value;
        }
    },
    MILE(MeasurementType.LENGTH) {
        @Override
        public float baseUnits(float value) {
            return MILE_TO_INCHES * value;
        }
    },

    TBSP(MeasurementType.VOLUME) {
        @Override
        public float baseUnits(float value) {
            return TBSP_TO_TSP * value;
        }
    },
    TSP(MeasurementType.VOLUME) {
        @Override
        public float baseUnits(float value) {
            return value;
        }
    },
    OZ(MeasurementType.VOLUME) {
        @Override
        public float baseUnits(float value) {
            return value * OZ_TO_TSP;
        }
    },
    CUP(MeasurementType.VOLUME) {
        @Override
        public float baseUnits(float value) {
            return value * CUP_TO_TSP;
        }
    }, CELSIUS(MeasurementType.TEMPERATURE) {
        @Override
        public float baseUnits(float value) {
           return value;
        }
    }, FAHRENHEIT(MeasurementType.TEMPERATURE) {
        @Override
        public float baseUnits(float value) {
            return ((value - 32) * 5) / 9;
        }
    };

    private MeasurementType measurementType;

    private static final int TBSP_TO_TSP = 3;
    private static final int OZ_TO_TSP = 2 * TBSP_TO_TSP;
    private static final int CUP_TO_TSP = 8 * OZ_TO_TSP;

    private static final int FEET_TO_INCHES = 12;
    private static final int YARD_TO_INCHES = 3 * FEET_TO_INCHES;
    private static final int MILE_TO_INCHES = 1760 * YARD_TO_INCHES;

    public abstract float baseUnits(float value);

    private Unit(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public boolean isCompatibleWith(Unit unit) {
        return this.measurementType == unit.measurementType;
    }

    public float convertTo(float value, Unit anotherUnit){
        if(! isCompatibleWith(anotherUnit))
            throw new IncompatibleUnitException();

        return baseUnits(value) / getConversionFactorOf(anotherUnit);
    }

    private float getConversionFactorOf(Unit anotherUnit) {
        return anotherUnit.baseUnits(1);
    }

    public MeasurementType getMeasurementType() {
        return measurementType;
    }
}

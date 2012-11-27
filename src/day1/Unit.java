package day1;


public enum Unit {
    FEET(MeasurementType.LENGTH) {
        @Override
        public int baseUnits(int value) {
            return FEET_TO_INCHES * value;
        }
    },
    INCH(MeasurementType.LENGTH) {
        @Override
        public int baseUnits(int value) {
            return value;
        }
    },
    YARD(MeasurementType.LENGTH) {
        @Override
        public int baseUnits(int value) {
            return YARD_TO_INCHES * value;
        }
    },
    MILE(MeasurementType.LENGTH) {
        @Override
        public int baseUnits(int value) {
            return MILE_TO_INCHES * value;
        }
    },
    TBSP(MeasurementType.VOLUME) {
        @Override
        public int baseUnits(int value) {
            return TBSP_TO_TSP * value;
        }
    },
    TSP(MeasurementType.VOLUME) {
        @Override
        public int baseUnits(int value) {
            return value;
        }
    };
    private MeasurementType measurementType;

    public static final int TBSP_TO_TSP = 3;

    public static final int FEET_TO_INCHES = 12;

    public static final int YARD_TO_INCHES = 3 * FEET_TO_INCHES;

    public static final int MILE_TO_INCHES = 1760 * YARD_TO_INCHES;

    public abstract int baseUnits(int value);

    private Unit(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }


    public boolean isSameGroup(Unit unit) {
        return this.measurementType == unit.measurementType;
    }
}

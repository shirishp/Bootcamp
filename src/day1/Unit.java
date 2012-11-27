package day1;


public enum Unit {
    FEET(MeasurementType.LENGTH) {
        @Override
        public float baseUnits() {
            return FEET_TO_INCHES ;
        }
    },
    INCH(MeasurementType.LENGTH) {
        @Override
        public float baseUnits() {
            return 1;
        }
    },
    YARD(MeasurementType.LENGTH) {
        @Override
        public float baseUnits() {
            return YARD_TO_INCHES;
        }
    },
    MILE(MeasurementType.LENGTH) {
        @Override
        public float baseUnits() {
            return MILE_TO_INCHES;
        }
    },
    TBSP(MeasurementType.VOLUME) {
        @Override
        public float baseUnits() {
            return TBSP_TO_TSP;
        }
    },
    TSP(MeasurementType.VOLUME) {
        @Override
        public float baseUnits() {
            return 1;
        }
    },

    OZ(MeasurementType.VOLUME) {
       @Override
       public float baseUnits() {
           return  OZ_TO_TSP ;
       }
    }, CUP(MeasurementType.VOLUME){
        @Override
        public float baseUnits() {
            return  CUP_TO_TSP ;
        }
    };
    private MeasurementType measurementType;


    private static final float TBSP_TO_TSP = 3;
    private static final float OZ_TO_TSP   =  2 * TBSP_TO_TSP;
    private static final float CUP_TO_TSP = 8 * OZ_TO_TSP;

    private static final float FEET_TO_INCHES = 12;
    private static final float YARD_TO_INCHES = 3 * FEET_TO_INCHES;
    private static final float MILE_TO_INCHES = 1760 * YARD_TO_INCHES;

    public abstract float baseUnits();

    private Unit(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public float convertTo(float value,Unit unit){
        if (!isCompatible(unit) )
            throw new RuntimeException("Incompatible types") ;
         return value * baseUnits()/unit.baseUnits();

    }

    public boolean isCompatible(Unit anotherUnit){
        return (measurementType.equals(anotherUnit.measurementType));
    }
}

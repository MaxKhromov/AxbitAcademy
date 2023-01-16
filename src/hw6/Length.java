package hw6;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Length {
    static final Long NANO_PER_INCH = 25400000L;
    static final Long NANO_PER_MILLIMETER = 1000000L;
    static final Long NANO_PER_CENTIMETER = 10000000L;
    static final Long NANO_PER_DECIMETER = 100000000L;
    static final Long NANO_PER_MILE = 1609344000000L;
    static final Long NANO_PER_METER = 1000000000L;
    static final Long NANO_PER_KILOMETER = 1000000000000L;

    private final Long nanometers;

    private Length(long nanometers) {
        super();
        this.nanometers = nanometers;
    }

    public static final Length ZERO = new Length(0);

    public static Length ofNanometers(Long nanometers) {
        return create(nanometers);
    }

    public static Length create(Long number) {
        if (number == 0) {
            return ZERO;
        }
        return new Length(number);
    }

    public static Length create(Long number, LengthUnits unit) {
        if (number == 0) {
            return ZERO;
        }
        return switch (unit) {
            case NANOMETERS -> new Length(number);
            case INCHES -> new Length(number * NANO_PER_INCH);
            case MILLIMETERS -> new Length(number * NANO_PER_MILLIMETER);
            case CENTIMETERS -> new Length(number * NANO_PER_CENTIMETER);
            case DECIMETERS -> new Length(number * NANO_PER_DECIMETER);
            case MILES -> new Length(number * NANO_PER_MILE);
            case METERS -> new Length(number * NANO_PER_METER);
            case KILOMETERS -> new Length(number * NANO_PER_KILOMETER);
        };
    }

    public BigDecimal get(LengthUnits unit) {
        BigDecimal nanometers = new BigDecimal(this.nanometers);
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        return switch (unit) {
            case NANOMETERS -> nanometers;
            case INCHES -> nanometers.divide(new BigDecimal(NANO_PER_INCH), mc);
            case MILLIMETERS -> nanometers.divide(new BigDecimal(NANO_PER_MILLIMETER), mc);
            case CENTIMETERS -> nanometers.divide(new BigDecimal(NANO_PER_CENTIMETER), mc);
            case DECIMETERS -> nanometers.divide(new BigDecimal(NANO_PER_DECIMETER), mc);
            case MILES -> nanometers.divide(new BigDecimal(NANO_PER_MILE), mc);
            case METERS -> nanometers.divide(new BigDecimal(NANO_PER_METER), mc);
            case KILOMETERS -> nanometers.divide(new BigDecimal(NANO_PER_KILOMETER), mc);
        };
    }
}

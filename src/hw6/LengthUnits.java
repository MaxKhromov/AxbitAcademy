package hw6;


public enum LengthUnits {
    NANOMETERS("NANOMETERS", Length.ofNanometers(1L)),

    INCHES("INCHES", Length.ofNanometers(Length.NANO_PER_INCH)),

    MILLIMETERS("MILLIMETERS", Length.ofNanometers(Length.NANO_PER_MILLIMETER)),

    CENTIMETERS("CENTIMETERS", Length.ofNanometers(Length.NANO_PER_CENTIMETER)),

    DECIMETERS("DECIMETERS", Length.ofNanometers(Length.NANO_PER_DECIMETER)),

    MILES("MILES", Length.ofNanometers(Length.NANO_PER_MILE)),

    METERS("METERS", Length.ofNanometers(Length.NANO_PER_METER)),

    KILOMETERS("KILOMETERS", Length.ofNanometers(Length.NANO_PER_KILOMETER));

    private final String name;
    private final Length length;

    LengthUnits(String name, Length length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public Length getLength() {
        return length;
    }
}

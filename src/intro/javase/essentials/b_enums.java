package intro.javase.essentials;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

class EnumTest {
    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
        case MONDAY:
            System.out.println("Mondays are bad.");
            break;

        case FRIDAY:
            System.out.println("Fridays are better.");
            break;

        case SATURDAY:
        case SUNDAY:
            System.out.println("Weekends are best.");
            break;

        default:
            System.out.println("Midweek days are so-so.");
            break;
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}

enum Planet {
    MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6) {
        @Override
        double surfaceGravity() {
            return 483743;
        }
    },
    JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

    // universal gravitational constant (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    private final double mass; // in kilograms
    private final double radius; // in meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    private double mass() {
        return mass;
    }

    private double radius() {
        return radius;
    }

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
    }
}

enum Modes {
    MODE_ONE {
        @Override
        public boolean canDoA() {
            return true;
        }
    },
    MODE_TWO {
        @Override
        public boolean canDoB() {
            return true;
        }
    },
    MODE_THREE {
        @Override
        public boolean canDoC() {
            return true;
        }
    };

    public boolean canDoA() {
        return false;
    }

    public boolean canDoB() {
        return false;
    }

    public boolean canDoC() {
        return false;
    }

}

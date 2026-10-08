package features.in.java12;
import java.time.DayOfWeek;

public class PreviewSwitchExpression  {

    public static void main(String[] args) {

        DayOfWeek day = DayOfWeek.SATURDAY;

        String activity = switch (day) {
            case SATURDAY, SUNDAY -> "Relax";
            case MONDAY -> "Try to work";
            default -> "Work";
        };

        System.out.println(activity);

    }
}

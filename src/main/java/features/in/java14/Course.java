package features.in.java14;
import java.time.Duration;

public record Course(String name, Duration duration, int rating) {
    public Course {
        if(rating > 5) {
            throw new IllegalArgumentException();
        }
    }
}

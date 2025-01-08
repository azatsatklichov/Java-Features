package best.practices.common;


import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDemo {

    public static void main(String[] args) {

        Instant hundredYearsAgo = Instant.now().minus(Duration.ofDays(100 * 365));
        Instant tenDaysAgo = Instant.now().minus(Duration.ofDays(10));
        Instant random = between(hundredYearsAgo, tenDaysAgo);
        System.out.println(random);

        System.out.println(getRandomNumber(12, 67));
        System.out.println(getRandomNumberUsingNextInt(12, 67));

        System.out.println(getRandomNumberUsingInts(12, 67));

        getSecureRandom();
    }

    public static Instant between(Instant startInclusive, Instant endExclusive) {
        long startSeconds = startInclusive.getEpochSecond();
        long endSeconds = endExclusive.getEpochSecond();
        long random = ThreadLocalRandom.current().nextLong(startSeconds, endSeconds);

        return Instant.ofEpochSecond(random);
    }

    public static Instant after(Instant startInclusive) {
        return between(startInclusive, Instant.MAX);
    }

    public static Instant before(Instant upperExclusive) {
        return between(Instant.MIN, upperExclusive);
    }


    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public static void getSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        int randomInt = secureRandom.nextInt();
        long randomLong = secureRandom.nextLong();
        float randomFloat = secureRandom.nextFloat();
        double randomDouble = secureRandom.nextDouble();
        boolean randomBoolean = secureRandom.nextBoolean();

        System.out
                .println(randomInt + "; " + randomLong + "; " +
                        randomFloat + ";" + randomDouble + ";" + randomBoolean);
    }
}
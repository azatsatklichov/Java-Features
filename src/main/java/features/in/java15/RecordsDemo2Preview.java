package features.in.java15;

import java.time.Duration;
public sealed interface Fruit permits Apple, Orange {}

record Apple() implements Fruit{}
record Orange() implements Fruit{}
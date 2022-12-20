package hw4.randomIntGenerator.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class RandomIntGenerator {

    public static List<Double> randomInt(Object startRange, Object endRange, Object size, int pointSize) {
        RandomGenerator generator = RandomGenerator.getDefault();
        return generator.doubles((Long) size, (Double) startRange, (Double) endRange)
                .map(s -> Double.parseDouble(String.valueOf(new BigDecimal(s).setScale(pointSize, RoundingMode.HALF_UP))))
                .boxed()
                .collect(Collectors.toList());
    }
}

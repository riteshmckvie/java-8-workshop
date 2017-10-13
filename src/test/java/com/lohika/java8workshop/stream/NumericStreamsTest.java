package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumericStreamsTest {

    @Test
    public void shouldFindSumUsingNumericStream() {
        List<Vehicle> vehicles = FleetFactory.get();

        int sum = vehicles.stream()
            .mapToInt(v -> v.getCubicCapacity())
            .sum();

        assertThat(sum, is(29200));
    }

    @Test
    public void shouldUseRangeToCreateAStream() {
        long count = IntStream.range(0, 100)
            .filter(n -> n % 2 == 0)
            .count();

        assertThat(count, is(50L));
    }
}

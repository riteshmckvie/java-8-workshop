package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumericStreamsTest {

    /**
     * The test demonstrates how to find a sum of elements of a numeric stream
     */
    @Test
    public void shouldFindSumUsingNumericStream() {
        List<Vehicle> vehicles = FleetFactory.get();

        int sum = vehicles.stream()
            .mapToInt(v -> v.getCubicCapacity())
            .sum();

        assertThat(sum, is(29200));
    }

    /**
     * The test demonstrates a stream from a range of elements.
     */
    @Test
    public void shouldUseRangeToCreateAStream() {
        long count = IntStream.range(0, 100)
            .filter(n -> n % 2 == 0)
            .count();

        assertThat(count, is(50L));
    }
}

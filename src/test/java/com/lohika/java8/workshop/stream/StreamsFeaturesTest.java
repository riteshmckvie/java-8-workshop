package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamsFeaturesTest {

    /**
     * The test demonstrates stream laziness. Map function will be executed
     * only for 3 elements, instead of all elements.
     */
    @Test
    public void shouldShowStreamLaziness() {
        long count = FleetFactory.get().stream()
            .peek(v -> System.out.println(v.getName()))
            .map(v -> v.getName())
            .limit(3)
            .count();

        assertThat(count, is(3L));
    }

    /**
     * The test demonstrates that stream could be traversed only one. Second attempt
     * will result in {@code IllegalStateException}.
     */
    @Test(expected = IllegalStateException.class)
    public void shouldShowStreamTraversableOnce() {
        Stream<Vehicle> vehicles = FleetFactory.get().stream();

        vehicles.forEach(v -> {});
        vehicles.forEach(v -> {});
    }

    /**
     * The test demonstrates that intermediate operations in sake of optimization could
     * be merged.
     */
    @Test
    public void shouldShowIntermediateOxperationsMerging() {
        FleetFactory.get().stream()
            .peek(v -> System.out.println("Filtering: \t" + v.getName()))
            .filter(v -> v.getCubicCapacity() > 2500)
            .peek(v -> System.out.println("Mapping: \t" + v.getName()))
            .map(v -> v.getName())
            .collect(toList());
    }
}

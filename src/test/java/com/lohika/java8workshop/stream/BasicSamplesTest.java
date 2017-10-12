package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasicSamplesTest {

    @Test
    public void shouldShowStreamLaziness() {
        long count = FleetFactory.get().stream()
            .map(v -> {
                System.out.println(v.getName());
                return v.getName();
            })
            .limit(3)
            .count();

        assertThat(count, is(3L));
    }

    @Test(expected = IllegalStateException.class)
    public void shouldShowStreamTraversation() {
        Stream<Vehicle> vehicles = FleetFactory.get().stream();

        vehicles.forEach(v -> {});
        vehicles.forEach(v -> {});
    }

    @Test
    public void shouldShowIntermediateOperationsMerging() {
        FleetFactory.get().stream()
            .filter(v -> {
                System.out.println("Filtering: \t" + v.getName());
                return v.getCubicCapacity() > 2500;
            })
            .map(v -> {
                System.out.println("Mapping: \t" + v.getName());
                return v.getName();
            })
            .collect(toList());
    }
}

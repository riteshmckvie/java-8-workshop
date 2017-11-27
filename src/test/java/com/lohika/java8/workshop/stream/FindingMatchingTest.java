package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindingMatchingTest {

    /**
     * The test demonstrates how to find out if any element match predicate.
     */
    @Test
    public void shouldMatchAny() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .anyMatch(v -> v.getCubicCapacity() > 4000);

        assertThat(hasPowerfulVehicle, is(true));
    }

    /**
     * The test demonstrates how to find out if all elements match
     * predicate.
     */
    @Test
    public void shouldMatchAll() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .allMatch(v -> v.isDiesel());

        assertThat(hasPowerfulVehicle, is(false));
    }

    /**
     * The test demonstrates how to find out if none elements match
     * predicate.
     */
    @Test
    public void shouldMatchNone() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .noneMatch(v -> v.getCubicCapacity() < 1000);

        assertThat(hasPowerfulVehicle, is(true));
    }

    /**
     * The test demonstrates how to find a single element matching predicate.
     */
    @Test
    public void shouldFindAny() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> any = vehicles.stream()
            .findAny();

        assertThat(any.isPresent(), is(true));
    }

    /**
     * The test demonstrates how to find first element matching predicate.
     */
    @Test
    public void shouldFindFirst() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> first = vehicles.stream()
            .skip(vehicles.size())
            .findAny();

        assertThat(first.isPresent(), is(false));
    }
}

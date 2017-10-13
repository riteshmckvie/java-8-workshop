package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindingMatchingTest {

    @Test
    public void shouldMatchAny() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .anyMatch(v -> v.getCubicCapacity() > 4000);

        assertThat(hasPowerfulVehicle, is(true));
    }

    @Test
    public void shouldMatchAll() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .allMatch(v -> v.isDiesel());

        assertThat(hasPowerfulVehicle, is(false));
    }

    @Test
    public void shouldMatchNone() {
        List<Vehicle> vehicles = FleetFactory.get();

        boolean hasPowerfulVehicle = vehicles.stream()
            .noneMatch(v -> v.getCubicCapacity() < 1000);

        assertThat(hasPowerfulVehicle, is(true));
    }

    @Test
    public void shouldFindAny() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> any = vehicles.stream()
            .findAny();

        assertThat(any.isPresent(), is(true));
    }

    @Test
    public void shouldFindFirst() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> first = vehicles.stream()
            .skip(vehicles.size())
            .findAny();

        assertThat(first.isPresent(), is(false));
    }
}

package com.lohika.java8.workshop.stream.collector;

import com.lohika.java8.workshop.stream.FleetFactory;
import com.lohika.java8.workshop.stream.Vehicle;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PartitioningTest {

    /**
     * The test demonstrates how to partition a stream using a predicate.
     */
    @Test
    public void shouldPartitionByFuelType() {
        List<Vehicle> vehicles = FleetFactory.get();

        Map<Boolean, List<Vehicle>> fleetByFuelType = vehicles.stream()
            .collect(partitioningBy(Vehicle::isDiesel));

        assertThat(fleetByFuelType.get(true).size(), is(6));
        assertThat(fleetByFuelType.get(false).size(), is(4));

        System.out.println(fleetByFuelType);
    }

    /**
     * The test demonstrates how to partition a stream using multiple criteria.
     */
    @Test
    public void shouldPartitionByFuelTypeAndCount() {
        List<Vehicle> vehicles = FleetFactory.get();

        Map<Boolean, Long> fleetByFuelTypeAndCount = vehicles.stream()
            .collect(partitioningBy(Vehicle::isDiesel, counting()));

        assertThat(fleetByFuelTypeAndCount.get(true), is(6L));
        assertThat(fleetByFuelTypeAndCount.get(false), is(4L));

        System.out.println(fleetByFuelTypeAndCount);
    }
}

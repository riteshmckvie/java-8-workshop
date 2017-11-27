package com.lohika.java8.workshop.stream.collector;

import com.lohika.java8.workshop.stream.FleetFactory;
import com.lohika.java8.workshop.stream.Vehicle;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupingTest {

    /**
     * The test demonstrates how to group a stream using a criteria function.
     */
    @Test
    public void shouldGroupByType() {
        List<Vehicle> vehicles = FleetFactory.get();

        Map<Vehicle.Type, List<Vehicle>> fleetByTypes = vehicles.stream()
            .collect(groupingBy(Vehicle::getType));

        assertThat(fleetByTypes.get(Vehicle.Type.CAR).size(), is(4));
        assertThat(fleetByTypes.get(Vehicle.Type.MINIBUS).size(), is(3));
        assertThat(fleetByTypes.get(Vehicle.Type.TRUCK).size(), is(3));

        System.out.println(fleetByTypes);
    }

    /**
     * The test demonstrates how to group a stream using a multiple criteria functions.
     */
    @Test
    public void shouldGroupByTypeAndFuelType() {
        List<Vehicle> vehicles = FleetFactory.get();

        Map<Vehicle.Type, Map<Boolean, List<Vehicle>>> fleetByTypeAndFuelType = vehicles.stream()
            .collect(groupingBy(Vehicle::getType, groupingBy(Vehicle::isDiesel)));

        assertThat(fleetByTypeAndFuelType.get(Vehicle.Type.CAR).size(), is(2));
        assertThat(fleetByTypeAndFuelType.get(Vehicle.Type.MINIBUS).size(), is(1));
        assertThat(fleetByTypeAndFuelType.get(Vehicle.Type.TRUCK).size(), is(2));

        System.out.println(fleetByTypeAndFuelType);
    }

    /**
     * The test demonstrates how to find an element in each group which is maximum
     * by provided {@code Comparator}.
     */
    @Test
    public void shouldGroupByTypeAndFindTheMostPowerful() {
        List<Vehicle> vehicles = FleetFactory.get();

        Map<Vehicle.Type, Optional<Vehicle>> fleetByTypeAndCC = vehicles.stream()
            .collect(groupingBy(Vehicle::getType, maxBy(Comparator.comparingInt(Vehicle::getCubicCapacity))));

        assertThat(fleetByTypeAndCC.get(Vehicle.Type.CAR).get().getName(), is("Aston Martin"));
        assertThat(fleetByTypeAndCC.get(Vehicle.Type.MINIBUS).get().getName(), is("Mercedes"));
        assertThat(fleetByTypeAndCC.get(Vehicle.Type.TRUCK).isPresent(), is("Scania"));

        System.out.println(fleetByTypeAndCC);
    }

}

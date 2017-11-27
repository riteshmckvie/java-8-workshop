package com.lohika.java8.workshop.stream.collector;

import com.lohika.java8.workshop.stream.FleetFactory;
import com.lohika.java8.workshop.stream.Vehicle;

import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReducingTest {

    /**
     * The test demonstrates how to count number of elements in a stream
     * using {@code Collector}.
     */
    @Test
    public void shouldCountVehicles() {
        List<Vehicle> vehicles = FleetFactory.get();

        long total = vehicles.stream()
            .collect(counting());

        assertThat(total, is(10L));
    }

    /**
     * The test demonstrates how to find maximum element in a stream
     * using {@code Collector}.
     */
    @Test
    public void shouldFindVehicleWithMaximumCC() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> maxCC = vehicles.stream()
            .collect(maxBy(Comparator.comparingInt(Vehicle::getCubicCapacity)));

        assertThat(maxCC.isPresent(), is(true));
        assertThat(maxCC.get().getCubicCapacity(), is(5400));
    }

    /**
     * The test demonstrates how to find minimum element in a stream
     * using {@code Collector}.
     */
    @Test
    public void shouldFindVehicleWithMinimumCC() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Vehicle> maxCC = vehicles.stream()
            .collect(minBy(Comparator.comparingInt(Vehicle::getCubicCapacity)));

        assertThat(maxCC.isPresent(), is(true));
        assertThat(maxCC.get().getCubicCapacity(), is(1200));
    }

    /**
     * The test demonstrates how to find an average element in a stream
     * using {@code Collector}.
     */
    @Test
    public void shouldFindAverageCC() {
        List<Vehicle> vehicles = FleetFactory.get();

        double averageCC = vehicles.stream()
            .collect(averagingInt(Vehicle::getCubicCapacity));

        assertThat(averageCC, is(2920.0));
    }

    /**
     * The test demonstrates how to find elements total in a stream
     * using {@code Collector}.
     */
    @Test
    public void shouldFindTotalCC() {
        List<Vehicle> vehicles = FleetFactory.get();

        int totalCC = vehicles.stream()
            .collect(summingInt(Vehicle::getCubicCapacity));

        assertThat(totalCC, is(29200));
    }

    /**
     * The test demonstrates how to find count, maximum, minimum, average and total
     * using one call to {@code Collector}.
     */
    @Test
    public void shouldShowStatistics() {
        List<Vehicle> vehicles = FleetFactory.get();

        IntSummaryStatistics statistics = vehicles.stream()
            .collect(summarizingInt(Vehicle::getCubicCapacity));

        assertThat(statistics.getCount(), is(10L));
        assertThat(statistics.getMax(), is(5400));
        assertThat(statistics.getMin(), is(1200));
        assertThat(statistics.getAverage(), is(2920.0));
        assertThat(statistics.getSum(), is(29200L));
    }

    /**
     * The test demonstrates how join a stream using {@code Collector}
     */
    @Test
    public void shouldJoinAllVehiclesNames() {
        List<Vehicle> vehicles = FleetFactory.get();

        String vehiclesNames = vehicles.stream()
            .map(v -> v.getName())
            .collect(joining(", "));


        assertThat(vehiclesNames, is("Mazda, Toyota, Volvo, Scania, Mann, Aston Martin, Nissan, Opel, Mercedes, Peugeot"));
    }
}

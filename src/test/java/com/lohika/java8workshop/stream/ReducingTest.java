package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReducingTest {

    @Test
    public void shouldFindSumByReduce() {
        List<Vehicle> vehicles = FleetFactory.get();

        Integer sum = vehicles.stream()
            .map(v -> v.getCubicCapacity())
            .reduce(0, (a, b) -> a + b);
//            .reduce(0, Integer::sum);

        assertThat(sum, is(29200));
    }

    @Test
    public void shouldFindMaxByReduce() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Integer> maybeMax = vehicles.stream()
            .map(v -> v.getCubicCapacity())
            .reduce(Integer::max);

        assertThat(maybeMax.get(), is(5400));
    }

    @Test
    public void shouldFindMinByReduce() {
        List<Vehicle> vehicles = FleetFactory.get();

        Optional<Integer> maybeMin = vehicles.stream()
            .map(v -> v.getCubicCapacity())
            .reduce(Integer::min);

        assertThat(maybeMin.get(), is(1200));
    }

    @Test
    public void shouldFindDieselVehicleCountByReduce() {
        List<Vehicle> vehicles = FleetFactory.get();

        long count = vehicles.stream()
            .filter(v -> v.isDiesel())
            .map(v -> v.getCubicCapacity())
            .count();

        assertThat(count, is(6L));
    }

}

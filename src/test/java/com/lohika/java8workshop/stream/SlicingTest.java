package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SlicingTest {

    @Test
    public void shouldLimitStream() {
        List<Vehicle> vehicles = FleetFactory.get();

        List<Vehicle> petrol = vehicles.stream()
            .filter(v -> !v.isDiesel())
            .limit(3)
            .collect(toList());

        assertThat(petrol.size(), is(3));
    }

    @Test
    public void shouldSkipEverything() {
        List<Vehicle> vehicles = FleetFactory.get();

        List<Vehicle> skipped = vehicles.stream()
            .skip(vehicles.size())
            .collect(toList());

        assertThat(skipped.isEmpty(), is(true));
    }
}

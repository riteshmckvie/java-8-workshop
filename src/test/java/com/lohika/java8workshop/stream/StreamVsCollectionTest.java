package com.lohika.java8workshop.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamVsCollectionTest {

    /**
     * The test demonstrates how filtering, sorting and mapping is implemented
     * using Java 7 or earlier.
     */
    @Test
    public void shouldProcessUsingCollectionApi() {
        List<Vehicle> fleet = FleetFactory.get();

        List<Vehicle> powerfulVehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (v.getCubicCapacity() > 2500) {
                powerfulVehicles.add(v);
            }
        }

        Collections.sort(powerfulVehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(final Vehicle o1, final Vehicle o2) {
                return o1.getCubicCapacity() - o2.getCubicCapacity();
            }
        });

        List<String> powerfulVehiclesNames = new ArrayList<>();
        for (Vehicle v : powerfulVehicles) {
            powerfulVehiclesNames.add(v.getName());
        }

        System.out.println(powerfulVehiclesNames);
        assertThat(powerfulVehiclesNames.size(), is(5));
    }

    /**
     * The test demonstrates how filtering, sorting and mapping is implemented
     * using Java 8 Streams.
     */
    @Test
    public void shouldProcessUsingStreamApi() {
        List<String> powerfulVehiclesNames = FleetFactory.get().stream()
            .filter(v -> v.getCubicCapacity() > 2500)
            .sorted(Comparator.comparingInt(Vehicle::getCubicCapacity))
            .map(v -> v.getName())
            .collect(toList());

        System.out.println(powerfulVehiclesNames);
        assertThat(powerfulVehiclesNames.size(), is(5));
    }

}

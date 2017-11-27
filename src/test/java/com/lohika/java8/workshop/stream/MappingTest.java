package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MappingTest {

    /**
     * The test demonstrates how to map a stream to another stream of
     * different elements.
     */
    @Test
    public void shouldCountNumberOfDistinctVehicleTypes() {
        List<Vehicle> vehicles = FleetFactory.get();

        List<Vehicle.Type> types = vehicles.stream()
            .map(v -> v.getType())
            .distinct()
            .collect(toList());

        System.out.println(types);
        assertThat(types.size(), is(3));
    }

    /**
     * The test demonstrates how to use a flatMap function to merge multiple
     * streams into one stream.
     */
    @Test
    public void shouldCountNumberOfDistinctCharactersUsedInVehicleNames() {
        List<Vehicle> vehicles = FleetFactory.get();

        List<String> letters = vehicles.stream()
            .map(v -> v.getName().toLowerCase())
            .map(name -> name.split(""))
            .flatMap(Arrays::stream)
            .filter(s -> Character.isAlphabetic(s.charAt(0)))
            .distinct()
            .collect(toList());

        System.out.println(letters);
        assertThat(letters.size(), is(18));
    }
}

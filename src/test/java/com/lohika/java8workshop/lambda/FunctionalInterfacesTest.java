package com.lohika.java8workshop.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionalInterfacesTest {

    private List<String> countries = Arrays.asList("USA", "France", "Ukraine", "Germany", "Great Britain");

    /**
     * The test demonstrates how to use a predicate for filtering.
     */
    @Test
    public void shouldShowPredicateUsage() {
        Predicate<String> startsWithG = s -> s.startsWith("G");

        List<String> filtered = filter(countries, startsWithG);

        assertThat(filtered, is(Arrays.asList("Germany", "Great Britain")));
    }

    private <T> List<T> filter(List<T> source, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T s: source) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }

        return result;
    }

    /**
     * The test demonstrates how to use a function to object transformation.
     */
    @Test
    public void shouldShowFunctionUsage() {
        Function<String, Integer> toLength = s -> s.length();

        List<Integer> lengths = transform(countries, toLength);

        assertThat(lengths, is(Arrays.asList(3, 6, 7, 7, 13)));
    }

    private <T, S> List<S> transform(List<T> source, Function<T, S> transformer) {
        List<S> result = new ArrayList<>();

        for (T s: source) {
            result.add(transformer.apply(s));
        }

        return result;
    }

    /**
     * The test demonstrates how to use a consumer for applying some
     * logic to each elements of a list.
     */
    @Test
    public void shouldShowConsumerUsage() {
        countries.forEach(s -> System.out.println(s.toUpperCase()));
    }

}

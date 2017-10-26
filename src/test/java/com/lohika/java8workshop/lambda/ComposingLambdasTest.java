package com.lohika.java8workshop.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;

import static java.util.Comparator.comparing;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComposingLambdasTest {

    List<String> source;

    @Before
    public void init() {
        source = Arrays.asList("Ukraine", "Great Britain", "USA", "France", "Germany");
    }

    /**
     * The test demonstrates how to sort a list by reversed order of the length of its elements.
     */
    @Test
    public void shouldSortInReverseOrder() {
        source.sort(comparing(String::length).reversed());

        assertThat(source, is(Arrays.asList("Great Britain", "Ukraine", "Germany", "France", "USA")));
    }

    /**
     * The test demonstrates how to sort a list by reversed order of the length of its elements, and the length
     * is equals then sort by case-insensitive natural order.
     */
    @Test
    public void shouldSortWithComposedComparator() {
        source.sort(comparing(String::length)
            .reversed()
           .thenComparing(String.CASE_INSENSITIVE_ORDER));

        assertThat(source, is(Arrays.asList("Great Britain", "Germany", "Ukraine", "France", "USA")));
    }

    @Test
    public void shouldComposePredicates() {
        // Will be shown during streams presentation.
    }

    /**
     * The test demonstrates how to create and use compound function, which will execute two operations.
     */
    @Test
    public void shouldComposeFunctions() {
        IntUnaryOperator f1 = x -> x + 1;
        IntUnaryOperator f2 = x -> x * 2;

        IntUnaryOperator f = f1.andThen(f2);

        assertThat(f.applyAsInt(10), is(22));
    }

}

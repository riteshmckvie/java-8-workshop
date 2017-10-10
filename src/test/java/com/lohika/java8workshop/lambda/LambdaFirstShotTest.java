package com.lohika.java8workshop.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaFirstShotTest {

    private List<String> source;
    private List<String> sorted = Arrays.asList("USA", "France", "Ukraine", "Germany", "Great Britain");

    @Before
    public void init() {
        source = Arrays.asList("Ukraine", "Great Britain", "USA", "France", "Germany");
    }

    @Test
    public void shouldSortUsingAnonymousClass() {
        source.sort(new Comparator<String>() {
            public int compare(final String o1, final String o2) {
                return o1.length() - o2.length();
            }
        });

        assertThat(source, is(sorted));
    }

    @Test
    public void shouldSortUsingLambda() {
        source.sort((o1, o2) -> o1.length() - o2.length());

        assertThat(sorted, is(source));
    }

    @Test
    public void shouldSortUsingComparingInt() {
        source.sort(Comparator.comparingInt(String::length));

        assertThat(sorted, is(source));
    }

}

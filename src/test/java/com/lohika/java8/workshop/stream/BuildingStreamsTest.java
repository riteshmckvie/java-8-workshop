package com.lohika.java8.workshop.stream;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuildingStreamsTest {

    /**
     * The test demonstrates how to create a stream of provided elements.
     */
    @Test
    public void shouldCreateStreamUsingOf() {
        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5);

        assertThat(nums.count(), is(5L));
    }

    /**
     * The test demonstrates how to create a stream from an array.
     */
    @Test
    public void shouldCreateStreamUsingArraysStream() {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        IntStream nums = Arrays.stream(arr);

        assertThat(nums.count(), is(5L));
    }

    /**
     * The test demonstrates how to create from a file.
     */
    @Test
    public void shouldCreateStreamUsingFilesLines() throws IOException, URISyntaxException {
        long wordsCount = Files.lines(Paths.get(ClassLoader.getSystemResource("lyrics.txt").toURI()))
            .map(line -> line.split(" "))
            .flatMap(Arrays::stream)
            .distinct()
            .count();

        assertThat(wordsCount, is(443L));
    }

    /**
     * The test demonstrates how to create an infinite stream.
     */
    @Test
    public void shouldCreateStreamUsingIterate() {
        Stream.iterate(1, n -> n * 2)
            .limit(10)
            .forEach(System.out::println);
    }

    /**
     * The test demonstrates how to create an infinite stream of generated values.
     */
    @Test
    public void shouldCreateStreamUsingGenerate() {
        Stream.generate(Math::random)
            .limit(10)
            .forEach(System.out::println);
    }

}

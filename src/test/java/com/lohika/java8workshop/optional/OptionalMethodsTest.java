package com.lohika.java8workshop.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalMethodsTest {

    @Test(expected = NullPointerException.class)
    public void shouldShowNullPointerOnInitialization() {
        Optional<String> maybeString = Optional.of(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldShowNullPointerOnGet() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.get();
    }

    @Test(expected = NullPointerException.class)
    public void shouldOrElseThrow() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.orElseThrow(NullPointerException::new);
    }

    @Test
    public void shouldOrElseGet() {
        Optional<String> maybeString = Optional.ofNullable(null);

        String value = maybeString.orElseGet(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "this took long to execute";
        });

        assertThat(value, is("this took long to execute"));
    }

    @Test
    public void shouldShowFilterUsage() {
        Insurance insurance = new Insurance("super-insurance");
        Optional<Insurance> maybeInsurance = Optional.of(insurance);

        maybeInsurance
            .filter(ins -> "super-insurance".equals(ins.getName()))
            .ifPresent(ins -> System.out.println("This is super-insurance"));
    }

    @Test
    public void shouldShowOrElseUsage() {
        Optional<String> maybeName = Optional.empty();
        assertThat(maybeName.orElse("else"), is("else"));

        maybeName = Optional.of("name");
        assertThat(maybeName.orElse("else"), is("name"));
    }

}

package com.lohika.java8workshop.datetime;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemporalAmountTest {

    /**
     * The test demonstrates Duration usage.
     */
    @Test
    public void shouldShowDuration() throws InterruptedException {
        Instant t1 = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant t2 = Instant.now();

        Duration between = Duration.between(t1, t2);

        System.out.println(between.getSeconds());
        assertThat(between.getSeconds() >= 1, is(true));
    }

    /**
     * The test demonstrates Period usage for finding difference between dates.
     */
    @Test
    public void shouldShowPeriod() {
        LocalDate d1 = LocalDate.of(2017, 1, 1);
        LocalDate d2 = LocalDate.of(2017, 6, 30);

        Period period = Period.between(d1, d2);

        assertThat(period.getDays(), is(29));
        assertThat(period.getMonths(), is(5));
        assertThat(period.getYears(), is(0));
    }

}

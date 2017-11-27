package com.lohika.java8.workshop.datetime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemporalAdjustersTest {

    /**
     * The test demonstrates TemporalAdjusters usage for "tricky" math
     * with dates.
     */
    @Test
    public void shouldShowTemporalAdjusters() {
        LocalDate date = LocalDate.of(2017, 3, 7);

        LocalDate nextYear = date.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println("Next year first day: " + nextYear);
        assertThat(nextYear.getYear(), is(2018));

        LocalDate lastFriday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        System.out.println("Last Friday: " + lastFriday);
        assertThat(lastFriday.getDayOfMonth(), is(31));

        LocalDate nextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("Next month first day: " + nextMonth);
        assertThat(nextMonth.getDayOfWeek(), is(DayOfWeek.SATURDAY));
    }
}

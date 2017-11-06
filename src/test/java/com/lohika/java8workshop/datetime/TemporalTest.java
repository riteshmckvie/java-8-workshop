package com.lohika.java8workshop.datetime;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemporalTest {

    /**
     * The test demonstrates LocalTime and ChronoField usage.
     */
    @Test
    public void shouldShowLocalTime() {
        LocalTime threeFifteen = LocalTime.of(3, 15, 0);

        LocalTime sixFifteen = threeFifteen.plusHours(3);
        LocalTime sevenFifteen = threeFifteen.plus(4, ChronoUnit.HOURS);

        assertThat(3, is(threeFifteen.getHour()));
        assertThat(6, is(sixFifteen.getHour()));
        assertThat(7, is(sevenFifteen.get(ChronoField.HOUR_OF_AMPM)));
    }

    /**
     * The test demonstrates getting by non-existing TemporalUnit for LocalTime.
     */
    @Test(expected = UnsupportedTemporalTypeException.class)
    public void shouldShowNoExistingTemporalUnit() {
        LocalTime threeFifteen = LocalTime.of(3, 15, 0);

        int dayOfMonth = threeFifteen.get(ChronoField.DAY_OF_MONTH);
    }

    /**
     * The test demonstrates LocalDate and ChronoField usage.
     */
    @Test
    public void shouldShowLocalDate() {
        LocalDate firstAug = LocalDate.of(2017, 8, 1);

        LocalDate lastSummerDay = firstAug.plusDays(30);
        LocalDate midAugust = lastSummerDay.minusDays(15);

        assertThat(midAugust.isBefore(lastSummerDay), is(true));
        assertThat(midAugust.isEqual(lastSummerDay), is(false));
    }

    /**
     * The test demonstrates LocalDateTime and ChronoField usage.
     */
    @Test
    public void shouldShowLocalDateTime() {
        LocalDate firstAug = LocalDate.of(2017, 8, 1);
        LocalDateTime firstAugTime = firstAug.atTime(3, 15, 0);

        assertThat(firstAugTime.get(ChronoField.MINUTE_OF_HOUR), is(15));
        assertThat(firstAugTime.get(ChronoField.MINUTE_OF_DAY), is(195));
    }

    /**
     * The test demonstrates getting non-existent ChronoField on Instant.
     */
    @Test(expected = UnsupportedTemporalTypeException.class)
    public void shouldShowInstance() {
        Instant now = Instant.now();

        now.get(ChronoField.MINUTE_OF_DAY);
    }

    /**
     * The test demonstrates ZonedDateTime usage.
     */
    @Test
    public void shouldShowZonedDateTime() {
        LocalTime threeFifteen = LocalTime.of(3, 15, 0);
        LocalDate firstAug = LocalDate.of(2017, 8, 1);
        LocalDateTime firstAugThreeFifteen = firstAug.atTime(threeFifteen);

        ZonedDateTime firstAugThreeFifteenInKyiv = firstAugThreeFifteen.atZone(ZoneId.of("Europe/Kiev"));
        ZonedDateTime firstAugOneFifteenInLondon = firstAugThreeFifteenInKyiv.withZoneSameInstant(ZoneId.of("Europe/London"));

        assertThat(firstAugThreeFifteenInKyiv.getHour(), is(3));
        assertThat(firstAugOneFifteenInLondon.getHour(), is(1));

    }
}

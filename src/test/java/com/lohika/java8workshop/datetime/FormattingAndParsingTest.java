package com.lohika.java8workshop.datetime;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FormattingAndParsingTest {

    /**
     * The test demonstrates how to format a date using predefined and custom format.
     */
    @Test
    public void shouldFormatDate() {
        LocalDateTime dateTime = LocalDateTime.of(2017, 6, 1, 4, 53, 47);

        DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
        String isoDateTime = format.format(dateTime);
        System.out.println(isoDateTime);
        assertThat(isoDateTime, is("2017-06-01T04:53:47"));

        DateTimeFormatter localizedFormat = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRANCE);
        String localDateTime = localizedFormat.format(dateTime);
        System.out.println(localDateTime);
        assertThat(localDateTime, is("01 juin 2017"));
    }

    /**
     * The test demonstrates how to parse a date using custom formatter.
     */
    @Test
    public void shouldParseDate() {
        DateTimeFormatter localizedFormat = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.FRANCE);

        LocalDate date = LocalDate.parse("01 juin 2017", localizedFormat);
        assertThat(date.getYear(), is(2017));
        assertThat(date.getMonth(), is(Month.JUNE));
        assertThat(date.getDayOfMonth(), is(1));

        TemporalAccessor temporalAccessor = localizedFormat.parse("01 juin 2017");
        assertThat(temporalAccessor.get(ChronoField.YEAR), is(2017));
        assertThat(temporalAccessor.get(ChronoField.MONTH_OF_YEAR), is(6));
        assertThat(temporalAccessor.get(ChronoField.DAY_OF_MONTH), is(1));
    }

}

package com.lohika.java8.workshop.hometask;

import com.lohika.java8.workshop.stream.hometask.Transaction;
import com.lohika.java8.workshop.stream.hometask.TransactionsFactory;

import org.junit.Test;

import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

/**
 * Calculate total amount of transactions for each month of 2017.
 */
public class Task7 {

    @Test
    public void totalByMonthTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        Map<Month, Integer> monthsStats = totalByMonth(transactions);

        assertThat(monthsStats.get(Month.JANUARY), is(545));
        assertThat(monthsStats.get(Month.FEBRUARY), is(780));
        assertThat(monthsStats.get(Month.MARCH), is(2880));
        assertThat(monthsStats.get(Month.APRIL), is(135));
        assertThat(monthsStats.get(Month.MAY), is(3455));
        assertThat(monthsStats.get(Month.JUNE), is(120));
        assertThat(monthsStats.get(Month.JULY), is(900));
        assertThat(monthsStats.get(Month.AUGUST), is(1485));
        assertThat(monthsStats.get(Month.SEPTEMBER), is(700));
        assertThat(monthsStats.get(Month.OCTOBER), is(nullValue()));
        assertThat(monthsStats.get(Month.NOVEMBER), is(900));
        assertThat(monthsStats.get(Month.DECEMBER), is(1750));
    }

    private Map<Month, Integer> totalByMonth(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

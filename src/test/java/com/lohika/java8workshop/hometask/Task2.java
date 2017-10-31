package com.lohika.java8workshop.hometask;

import com.lohika.java8workshop.stream.hometask.Transaction;
import com.lohika.java8workshop.stream.hometask.TransactionsFactory;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Sort transactions totals in descending order.
 */
public class Task2 {

    @Test
    public void sortTransactionsTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        List<Integer> sorted = sortTransactions(transactions);

        assertThat(sorted.size(), is(17));
        assertThat(sorted, is(equalTo(Arrays.asList(2540, 1750, 1340, 1200, 900, 900, 835, 780, 700, 650, 545, 450, 345, 340, 135, 120, 120))));
    }

    private List<Integer> sortTransactions(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

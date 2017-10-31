package com.lohika.java8workshop.hometask;

import com.lohika.java8workshop.stream.hometask.Transaction;
import com.lohika.java8workshop.stream.hometask.TransactionsFactory;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Find total of all transactions.
 */
public class Task3 {

    @Test
    public void sortTransactionsTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        Optional<Integer> total = findTotal(transactions);

        assertThat(total.get(), is(13650));
    }

    private Optional<Integer> findTotal(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

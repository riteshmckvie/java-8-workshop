package com.lohika.java8.workshop.hometask;

import com.lohika.java8.workshop.stream.hometask.Transaction;
import com.lohika.java8.workshop.stream.hometask.TransactionsFactory;

import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * Find transactions which have been made in first half of 2017 year.
 */
public class Task1 {

    @Test
    public void filterTransactionsTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        List<Transaction> firstHalfTransactions = filterTransactions(transactions);

        assertThat(firstHalfTransactions.size(), is(11));
        List<Integer> ids = firstHalfTransactions.stream()
            .map(tr -> tr.getId())
            .collect(toList());
        assertThat(ids, containsInAnyOrder(1, 2, 3, 6, 7, 8, 9, 10, 13, 14, 17));
    }

    private List<Transaction> filterTransactions(final List<Transaction> transactions) {
        // Your implementation goes here
       return null;
    }

}

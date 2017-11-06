package com.lohika.java8workshop.hometask;

import com.lohika.java8workshop.stream.hometask.Transaction;
import com.lohika.java8workshop.stream.hometask.TransactionsFactory;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Find the most popular item.
 */
public class Task6 {

    @Test
    public void mostPopularItemTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        Map.Entry<String, Long> max = mostPopularItem(transactions);

        assertThat(max.getKey(), is("Fruits"));
        assertThat(max.getValue(), is(3L));
    }

    /**
     * The most popular item is the item occurred most times in transaction description.
     * In the following examples 'Fruits' is the most popular item:
     *  transaction1(..., 'Fruits Cookies Vegetables', ...)
     *  transaction2(..., 'Fruits', ...)
     *  transaction3(..., 'Candies', ...)
     */
    private Map.Entry<String, Long> mostPopularItem(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

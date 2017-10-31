package com.lohika.java8workshop.hometask;

import com.lohika.java8workshop.stream.hometask.Transaction;
import com.lohika.java8workshop.stream.hometask.TransactionsFactory;
import com.lohika.java8workshop.stream.hometask.Type;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Find the most expensive transaction in each category.
 */
public class Task4 {

    @Test
    public void groupingByMaxTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        Map<Type, Transaction> map = mostExpensive(transactions);

        assertThat(map.size(), is(5));
        assertThat(map.get(Type.BOOKS).getId(), is(10));
        assertThat(map.get(Type.BEAUTY).getId(), is(3));
        assertThat(map.get(Type.CLOTHING).getId(), is(11));
        assertThat(map.get(Type.ELECTRONICS).getId(), is(4));
        assertThat(map.get(Type.GROCERY).getId(), is(5));
    }

    private Map<Type, Transaction> mostExpensive(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

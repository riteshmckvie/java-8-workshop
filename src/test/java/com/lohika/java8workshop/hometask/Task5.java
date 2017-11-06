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
 * Calculate the total count of transactions in each category.
 */
public class Task5 {

    @Test
    public void groupingByTotalCountTest() {
        List<Transaction> transactions = TransactionsFactory.get();

        Map<Type, Long> map = totalCount(transactions);

        assertThat(map.size(), is(5));

        assertThat(map.get(Type.BOOKS), is(3L));
        assertThat(map.get(Type.BEAUTY), is(2L));
        assertThat(map.get(Type.CLOTHING), is(5L));
        assertThat(map.get(Type.ELECTRONICS), is(4L));
        assertThat(map.get(Type.GROCERY), is(3L));
    }

    private Map<Type, Long> totalCount(final List<Transaction> transactions) {
        // Your implementation goes here
        return null;
    }

}

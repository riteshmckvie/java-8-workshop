package com.lohika.java8workshop.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class MethodReferencesTest {

    @Test
    public void shouldShowStaticMethodReference() {
        IntBinaryOperator operator;

        operator = Math::max;
        assertThat(operator.applyAsInt(1,2), is(2));

        operator = Math::min;
        assertThat(operator.applyAsInt(1,2), is(1));
    }

    @Test
    public void shouldShowNonStaticMethodReference() {
        BiFunction<String, String, String> function;

        function = String::concat;

        assertThat(function.apply("head", "-tail"), is("head-tail"));
        assertThat(function.apply("tail", "-head"), is("tail-head"));
    }

    @Test
    public void shouldShowInstanceMethodReference() {
        Function<String, String> function;

        function = "head"::concat;
        assertThat(function.apply( "-tail"), is("head-tail"));

        function = "tail"::concat;
        assertThat(function.apply("-head"), is("tail-head"));
    }

    @Test
    public void shouldShowConstructorMethodReference() {
        Supplier<List> supplier;

        supplier = ArrayList::new;
        assertThat(supplier.get(), instanceOf(ArrayList.class));
        assertThat(supplier.get(), not(instanceOf(LinkedList.class)));

        supplier = LinkedList::new;
        assertThat(supplier.get(), instanceOf(LinkedList.class));
        assertThat(supplier.get(), not(instanceOf(ArrayList.class)));
    }

}




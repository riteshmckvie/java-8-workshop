package com.lohika.java8.workshop.lambda;

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

    /**
     * The test demonstrates how to use a reference to static method.
     */
    @Test
    public void shouldShowStaticMethodReference() {
        IntBinaryOperator operator;

        operator = Math::max;
        assertThat(operator.applyAsInt(1,2), is(2));

        operator = Math::min;
        assertThat(operator.applyAsInt(1,2), is(1));
    }

    /**
     * The test demonstrates how to use a reference to non-static method.
     */
    @Test
    public void shouldShowNonStaticMethodReference() {
        BiFunction<String, String, String> function;

        function = String::concat;

        //"head".concat("-tail");
        assertThat(function.apply("head", "-tail"), is("head-tail"));
        assertThat(function.apply("tail", "-head"), is("tail-head"));
    }

    /**
     * The test demonstrates how to use a reference to object instance method.
     */
    @Test
    public void shouldShowInstanceMethodReference() {
        Function<String, String> function;

        function = "head"::concat;
        assertThat(function.apply( "-tail"), is("head-tail"));

        function = "tail"::concat;
        assertThat(function.apply("-head"), is("tail-head"));
    }

    /**
     * The test demonstrates how to use a reference to constructor.
     */
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




package com.lohika.java8workshop.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExamples {

    public static void main(String[] args) {
        Predicate<List<String>> emptyList = (List<String> list) -> list.isEmpty();

        Supplier<List> listCreate = () -> new ArrayList(10);

        Consumer<String> printer = (String s) -> { System.out.println(s.length()); };

        Function<String, Integer> calculator = (String s) -> s.length();

        IntBinaryOperator adder = (int a, int b) -> a * b;
    }

}

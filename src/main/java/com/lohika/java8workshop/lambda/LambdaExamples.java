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
        Predicate<List<String>> emptyListOldStyle = new Predicate<List<String>>() {
            @Override
            public boolean test(final List<String> list) {
                return list.isEmpty();
            }
        };

        // No braces around parameter
        Predicate<List<String>> emptyList = list -> list.isEmpty();

        // No parameters
        Supplier<List> listCreate = () -> new ArrayList(10);

        // Multiple statements in the body
        Consumer<String> printer = s -> {
            System.out.println("In lambda");
            System.out.println(s.length());
        };

        // Curly braces and return keyword could be ommitted
        Function<String, Integer> calculator = (String s) -> { return s.length(); };

        // No parameters type declared
        IntBinaryOperator adder = (a, b) -> a * b;
    }

}

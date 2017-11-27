package com.lohika.java8.workshop.lambda;

import java.util.function.Supplier;

public class ValidInValidLambdas {

    public static void main(String[] args) {
        Runnable runnable = () -> {};

        Supplier<String> supplierShort = () -> "This is lambda";

        Supplier<String> supplierLong = () -> {return "This is lambda";};

        // invalid: no braces
//        Function<Integer, String> concat = (Integer i) -> return "Lambda #" + i;

        // invalid: no return keyword
//        Function<String, String> process = (String s) -> {"Java 8";}
    }

}

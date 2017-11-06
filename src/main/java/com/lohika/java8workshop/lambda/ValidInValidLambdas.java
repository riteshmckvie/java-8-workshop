package com.lohika.java8workshop.lambda;

import java.util.function.Supplier;

public class ValidInValidLambdas {

    public static void main(String[] args) {
        Runnable runnable = () -> {};

        Supplier<String> supplierShort = () -> "Raoul";

        Supplier<String> supplierLong = () -> {return "Mario";};

        // invalid: no braces
//        Function<Integer, String> concat = (Integer i) -> return "Alan" + i;

        // invalid: no return keyword
//        Function<String, String> process = (String s) -> {"Iron Man";}
    }

}

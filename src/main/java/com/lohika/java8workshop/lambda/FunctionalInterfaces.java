package com.lohika.java8workshop.lambda;

public class FunctionalInterfaces {
    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    // not a functional interface: has two 'add' methods
    public interface SmartAdder extends Adder {
        int add(double a, double b);
    }

    // not a functional interface: no methods
    public interface Nothing {
    }
}

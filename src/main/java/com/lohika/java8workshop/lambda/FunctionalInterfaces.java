package com.lohika.java8workshop.lambda;

public class FunctionalInterfaces {
    public interface Adder {
        int add(int a, int b);
    }

    public interface SmartAdder extends Adder {
        int add(double a, double b);
    }

    public interface Nothing {
    }
}

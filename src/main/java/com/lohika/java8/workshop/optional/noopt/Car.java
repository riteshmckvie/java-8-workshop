package com.lohika.java8.workshop.optional.noopt;

import com.lohika.java8.workshop.optional.Insurance;

public class Car {
    private final Insurance insurance;

    public Car(final Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getInsurance() {
        return insurance;
    }
}

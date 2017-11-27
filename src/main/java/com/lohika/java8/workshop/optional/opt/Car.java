package com.lohika.java8.workshop.optional.opt;

import com.lohika.java8.workshop.optional.Insurance;

import java.util.Optional;

public class Car {
    private final Insurance insurance;

    public Car(final Insurance insurance) {
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}

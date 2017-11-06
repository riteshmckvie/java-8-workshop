package com.lohika.java8workshop.optional.opt;

import com.lohika.java8workshop.optional.Insurance;

import java.util.Optional;

public class Car {
    private final Optional<Insurance> insurance;

    public Car(final Insurance insurance) {
        this.insurance = Optional.ofNullable(insurance);
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}

package com.lohika.java8.workshop.optional.opt;

import java.util.Optional;

public class Person {
    private final Optional<Car> car;

    public Person(final Car car) {
        this.car = Optional.ofNullable(car);
    }

    public Optional<Car> getCar() {
        return car;
    }
}

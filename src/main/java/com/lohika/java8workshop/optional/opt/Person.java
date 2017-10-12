package com.lohika.java8workshop.optional.opt;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Person(final Car car) {
        this.car = Optional.ofNullable(car);
    }

    public Optional<Car> getCar() {
        return car;
    }
}

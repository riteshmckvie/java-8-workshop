package com.lohika.java8workshop.optional.noopt;

public class Person {
    private final Car car;

    public Person(final Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}

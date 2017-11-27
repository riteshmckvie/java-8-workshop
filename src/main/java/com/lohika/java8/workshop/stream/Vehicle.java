package com.lohika.java8.workshop.stream;

public class Vehicle {
    private final String name;
    private final boolean diesel;
    private final int cubicCapacity;
    private final Type type;

    public Vehicle(final String name, final boolean diesel, final int cubicCapacity, final Type type) {
        this.name = name;
        this.diesel = diesel;
        this.cubicCapacity = cubicCapacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isDiesel() {
        return diesel;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        CAR, MINIBUS, TRUCK
    }
}

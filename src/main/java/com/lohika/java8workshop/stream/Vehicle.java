package com.lohika.java8workshop.stream;

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

    public static enum Type {
        CAR, MINIBUS, TRUCK
    }
}

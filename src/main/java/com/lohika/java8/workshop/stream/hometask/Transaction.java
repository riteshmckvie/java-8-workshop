package com.lohika.java8.workshop.stream.hometask;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private String description;
    private Type type;
    private LocalDate date;
    private int total;

    public Transaction(final int id, final String description, final Type type, final LocalDate date, final int total) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.date = date;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotal() {
        return total;
    }
}

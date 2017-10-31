package com.lohika.java8workshop.stream.hometask;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TransactionsFactory {
    public static List<Transaction> get() {
        return Arrays.asList(
            new Transaction(1, "Fruits", Type.GROCERY,        LocalDate.of(2017, 5, 24), 450),
            new Transaction(2, "Novels", Type.BOOKS,          LocalDate.of(2017, 4, 12), 135),
            new Transaction(3, "Shampoo", Type.BEAUTY,         LocalDate.of(2017, 3, 13), 1200),
            new Transaction(4, "TVs Playstation", Type.ELECTRONICS,    LocalDate.of(2017, 12, 29), 1750),
            new Transaction(5, "Fish Fruits Vegetables", Type.GROCERY,        LocalDate.of(2017, 11, 24), 900),
            new Transaction(6, "Smartphones Laptops", Type.ELECTRONICS,    LocalDate.of(2017, 5, 30), 345),
            new Transaction(7, "Pants", Type.CLOTHING,       LocalDate.of(2017, 5, 2), 120),
            new Transaction(8, "Pants T-Shirts", Type.CLOTHING,       LocalDate.of(2017, 2, 7), 780),
            new Transaction(9, "TVs Smaphones", Type.ELECTRONICS,    LocalDate.of(2017, 3, 30), 1340),
            new Transaction(10, "Fairytale", Type.BOOKS,         LocalDate.of(2017, 5, 31), 2540),
            new Transaction(11, "Shoes", Type.CLOTHING,      LocalDate.of(2017, 7, 4), 900),
            new Transaction(12, "Smartphones", Type.ELECTRONICS,   LocalDate.of(2017, 8, 19), 650),
            new Transaction(13, "Underwear", Type.CLOTHING,      LocalDate.of(2017, 3, 13), 340),
            new Transaction(14, "Detectives", Type.BOOKS,         LocalDate.of(2017, 1, 15), 545),
            new Transaction(15, "Shoes Underwear", Type.CLOTHING,      LocalDate.of(2017, 9, 22), 700),
            new Transaction(16, "Lipstick", Type.BEAUTY,        LocalDate.of(2017, 8, 28), 835),
            new Transaction(17, "Fruits", Type.GROCERY,       LocalDate.of(2017, 6, 3), 120)
                            );
    }
}

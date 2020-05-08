package com.example.demo.supplier;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<Integer> supply42 = () -> 42;
        System.out.println(supply42.get());
    }
}

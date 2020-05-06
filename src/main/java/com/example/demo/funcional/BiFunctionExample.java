package com.example.demo.funcional;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        BiFunction<Double, Integer, Double> function = (var x, var y) ->  x + y;
        System.out.println(function.apply(10.0, 10));
    }
}

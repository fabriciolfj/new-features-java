package com.example.demo.v1.iterate;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.iterate(1 ,i -> ++i).limit(9).forEach(System.out::print);
        System.out.println();
        Stream.iterate(1, i-> i < 10, i -> ++i).forEach(System.out::print);
    }
}

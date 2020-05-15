package com.example.demo.generate;

import java.util.Random;
import java.util.stream.Stream;

public class Main {

    //cria um fluxo inifinto
    public static void main(String[] args) {
        Stream.generate(() -> 1).limit(5)
                .forEach(System.out::print);

        Stream.generate(() -> new Random().nextDouble()).limit(5)
                .forEach(System.out::println);
    }
}

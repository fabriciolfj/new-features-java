package com.example.demo.stream;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.empty().forEach(System.out::println);
        Stream.of(1,2,3).forEach(System.out::println);

        Stream<Integer> stream1 = Stream.of(1,2,3);
        Stream<Integer> stream2 = Stream.of(4,5,6);

        Stream.of(stream1,stream2).flatMap(s -> s).forEach(System.out::print);


    }
}

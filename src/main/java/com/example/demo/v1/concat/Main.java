package com.example.demo.v1.concat;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream<Integer> stream1 = List.of(1,2).stream();
        Stream<Integer> stream2 = List.of(2,3).stream();
        Stream.concat(stream1,stream2)
                .forEach(System.out::print);
    }
}

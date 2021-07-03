package com.example.demo.v1.operacoesintermediarias.map;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "5", "6");

        list.stream().mapToInt(Integer::valueOf)
                .flatMap(n -> IntStream.iterate(1, i -> i < n, i -> ++i))
                .forEach(System.out::print);

        //flatMapToLong
        list.stream().map(Integer::valueOf)
                .flatMapToInt(n -> IntStream.iterate(1, i -> i < n, i -> ++i))
                .forEach(System.out::println);
        
        list.stream().map(Integer::valueOf)
                .flatMapToDouble(n -> DoubleStream.iterate(1, i -> i < n, i -> ++i))
                .mapToObj(Double::toString)
                .map(s -> s + " ")
                .forEach(System.out::print);

        System.out.println("");
    }

    private static void map() {
        List<String> list = List.of("1", "2", "3", "4", "5", "6");

        list.stream().map(s -> s + 1).forEach(System.out::print);

        System.out.println("");

        list.stream().mapToInt(Integer::valueOf).forEach(System.out::print);

        System.out.println("");

        list.stream().mapToLong(Long::valueOf).forEach(System.out::print);

        System.out.println("");

        list.stream().mapToDouble(Double::valueOf).forEach(System.out::print);
    }
}

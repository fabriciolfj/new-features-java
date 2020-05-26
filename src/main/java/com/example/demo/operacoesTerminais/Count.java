package com.example.demo.operacoesTerminais;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Count {

    public static void main(String[] args) {
        var count = Stream.of("1", "1", "1").count(); // não emite eventos.
        System.out.println(count);

        var countCollect = Stream.of("1", "1", "1").peek(System.out::println).collect(Collectors.counting());
        System.out.println(countCollect);
    }
}

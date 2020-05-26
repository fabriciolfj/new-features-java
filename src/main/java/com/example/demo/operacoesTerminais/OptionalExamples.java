package com.example.demo.operacoesTerminais;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExamples {

    public static void main(String[] args) {
        var list = List.of("1","2","3","4","5");

        var result = list.stream()
                .filter(e -> "42".equals(e))
                .findAny()
                .or(() -> Optional.of("not found"))
                .get();

        System.out.println(result);

        result = list.stream()
                .filter(e -> "42".equals(e))
                .findAny()
                .orElse("Not found");

        System.out.println(result);

        Supplier<String> trySomethingElse = () -> {
            return " 43";
        };

        result = list.stream()
                .filter(e -> "42".equals(e))
                .findAny()
                .orElseGet(trySomethingElse);

        System.out.println(result);

        list.stream()
                .filter(e -> "42".equals(e))
                .findAny()
                .ifPresentOrElse(System.out::println
                , () -> System.out.println("Not found"));


    }
}

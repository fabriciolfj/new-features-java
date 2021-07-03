package com.example.demo.v1.streambuilder;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //add retorna o objeto adicionado, permitindo criar um encadeamento
        Stream.<String>builder().add("cat").add(" dog").add(" bear").build().forEach(System.out::println);

        Stream.Builder<Integer> builder = Stream.builder();
        List.of(1,2,3).stream().forEach(builder); //aqui ele está utilizando o metodo accept por traz
        builder.build().forEach(System.out::println);

        //mostrando de forma explicita o accept
        List<String> values = List.of("cat", " dog", " bear");
        Stream.Builder<String> builder1 = Stream.builder();
        for(String s : values) {
            if(s.contains("a")) {
                builder1.accept(s);
            }
        }

        builder1.build().forEach(System.out::print);
    }
}

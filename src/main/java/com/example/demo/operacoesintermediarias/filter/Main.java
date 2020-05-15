package com.example.demo.operacoesintermediarias.filter;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of(1,2,3,3,5,6,6,7).distinct().forEach(System.out::print);

        System.out.println("");

        List.of(1,2,3,4,5,6,7).stream().skip(3).forEach(System.out::print);// pular os 3 primeiros elementos

        System.out.println("");

        List.of(1,2,3,4,5,6,7).stream().limit(3).forEach(System.out::print); //pegar apenas os 3 primeiros elementos.

        System.out.println("");

        List.of(1,2,3,4,5,6,7).stream().filter(s -> s == 3).forEach(System.out::print);

        System.out.println("");

        List.of(1,2,3,4,5,6,7).stream().dropWhile(s -> s < 4).forEach(System.out::print); // mostra os dados que atenderem ao predicate no caso menores que 4

        System.out.println("");

        List.of(1,2,3,4,5,6,7).stream().takeWhile(s -> s < 4).forEach(System.out::print); // descarta os dados que atenderem ao predicate no caso menores que 4

        System.out.println("");

        System.out.println("");
    }
}

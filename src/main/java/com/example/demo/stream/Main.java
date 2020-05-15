package com.example.demo.stream;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.empty().forEach(System.out::println);
        Stream.of(1,2,3).forEach(System.out::println);

        Stream<Integer> stream1 = Stream.of(1,2,3);
        Stream<Integer> stream2 = Stream.of(4,5,6);

        Stream.of(stream1,stream2).flatMap(s -> s).forEach(System.out::print);
        printList(Arrays.asList("Fabricio", "lucas"));
        printList(null);

        test();
    }

    private static void test() {
        System.out.println(ObjectUtils.compare(1,1));
        System.out.println(ObjectUtils.compare(1,0));
    }

    private static void printList(List<String> names) {
        Stream.ofNullable(names).flatMap(Collection::stream).forEach(System.out::println);
    }
}

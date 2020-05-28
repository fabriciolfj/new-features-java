package com.example.demo.numberStream;

import com.example.demo.model.Person;

import java.util.List;
import java.util.stream.IntStream;

public class NumberMain {

    public static void main(String[] args) {
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        new NumberMain().boxed();
        new NumberMain().mapToObj();
        new NumberMain().flatMapToInt();    
        new NumberMain().sumAverage();
    }

    private void sumAverage() {
        int sum = IntStream.rangeClosed(1,3)
                .sum();

        double average = IntStream.rangeClosed(1,3).average().orElse(0.0);

        System.out.println(sum);
        System.out.println(average);
    }

    private void boxed() {
        IntStream.rangeClosed(1,3).boxed().map(Integer::shortValue).forEach(System.out::print);
    }

    private void mapToObj() {
        IntStream.rangeClosed(1,3)
                .mapToObj(e -> new Person(e, "teste"))
                .forEach(System.out::println);;
    }

    private void flatMapToInt() {
        List<Integer> list = List.of(1,2,3);
        list.stream()
                .flatMapToInt( i -> IntStream.rangeClosed(1 , i))
                .forEach(System.out::println);
    }
}

package com.example.demo.v1.predicate;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> isLessThan10 = i -> i < 10;
        Predicate<Integer> isLessThan14 = i -> i > 14;
        System.out.println(isLessThan10.test(5));
        System.out.println(isLessThan10.test(12));

        System.out.println(isLessThan10.or(isLessThan14).test(12));
        System.out.println(isLessThan10.and(isLessThan14).test(12));
    }
}

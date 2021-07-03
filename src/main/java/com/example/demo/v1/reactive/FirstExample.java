package com.example.demo.v1.reactive;

import io.reactivex.Observable;

public class FirstExample {

    public static void main(String[] args) {
       /* double a = IntStream.rangeClosed(1,5)
                .filter(i -> i % 2 ==  0)
                .mapToDouble(Double::valueOf)
                .map(Math::sqrt)
                .sum();

        System.out.println(a);

        // utilizando rxjava

        Observable.range(1, 5)
                .filter(i -> i % 2 == 0)
                .map(Math::sqrt)
                .reduce((r,d) -> r + d)
                .subscribe(System.out::println);*/

        new FirstExample().cache();
    }

    private void cache() {
        Observable<Double> observable = Observable.range(1,5)
                .filter(i -> i % 2 == 0)
                .doOnNext(System.out::println)
                .map(Math::sqrt)
                .cache();

        observable.reduce((r, d) ->  r + d)
                .subscribe(System.out::println);
    }
}

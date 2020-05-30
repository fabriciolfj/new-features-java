package com.example.demo.reactive.conditional;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Example1 {

    public static void main(String[] args) {
        Observable<String> obs = Observable.just("one")
            .flatMap(s -> Observable.fromArray(s.split("")));

        Single<Boolean> cont = obs.contains("n");
        System.out.println(cont.blockingGet()); // retorna true

        System.out.println("=====================");

        obs.defaultIfEmpty("two")
                .subscribe(System.out::println); // nao está vazia, então imprimirá one

        System.out.println("=====================");

        Observable.empty().defaultIfEmpty("two")
                .subscribe(System.out::println); // está vazio, vai imprimir two

        System.out.println("=====================");

        Single<Boolean> equal = Observable.sequenceEqual(obs, Observable.just("one")); // vai imprimir false, pois obs e um array de eventos e nao string one
        System.out.println(equal.blockingGet());

        System.out.println("=====================");

        equal = Observable.sequenceEqual(Observable.just("one"), Observable.just("one")); // vai retornar true
        System.out.println(equal.blockingGet());
    }
}

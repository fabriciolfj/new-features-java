package com.example.demo.v1.reactive.exceptions;

import io.reactivex.Observable;

public class Example1 {

    public static void main(String[] args) {
        Observable<String> obs = Observable.just("one")
                .flatMap(s -> Observable.fromArray(s.split("")));

        Observable.error(new RuntimeException("minha exception"))
                .flatMap(x -> Observable.fromArray("two".split("")))
                .subscribe(System.out::println, e -> System.out.println(e.getMessage())); // expoe a exceção

        Observable.error(new RuntimeException("minha exception"))
                .flatMap(y -> Observable.fromArray("two".split("")))
                .onErrorResumeNext(obs)
                .subscribe(System.out::print); //ao cair na exceção, emitirá obs

        Observable.error(new RuntimeException("minha exception"))
                .flatMap(y -> Observable.fromArray("two".split("")))
                .onErrorReturnItem("42")
                .subscribe(System.out::println); //ao cair na exceção, emitirá o valor 42
    }
}

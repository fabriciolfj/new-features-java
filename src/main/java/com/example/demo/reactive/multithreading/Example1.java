package com.example.demo.reactive.multithreading;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        Observable.fromArray("one", "two", "three")
                .doAfterNext(s -> System.out.println("1: " + s))
                .flatMap(w -> Observable.fromArray(w.split(""))
                .observeOn(Schedulers.computation()) // usa o números de cores do processador
                        .flatMap(s -> {
                            return Observable.just(s);
                        }).doAfterNext(s -> System.out.println("2: " + Thread.currentThread().getName() + "=>" + s)))
                        .subscribe(s -> System.out.println("3: " + s));


        try {
            TimeUnit.MILLISECONDS.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

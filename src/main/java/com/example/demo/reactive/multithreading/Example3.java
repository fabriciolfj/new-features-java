package com.example.demo.reactive.multithreading;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example3 {

    public static void main(String[] args) {
        maneira2();
    }

    private static void maneira2() {
        Observable.just("a", "b", "c")
                .subscribeOn(Schedulers.computation()) // não importa a posição
                .doAfterNext(s -> System.out.println("1: " + Thread.currentThread().getName() + " => " + s))
                .subscribe(s -> System.out.println("2: " + Thread.currentThread().getName() + " => " + s));

        try {
            TimeUnit.MILLISECONDS.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void maneira1() {
        Observable.just("a", "b", "c")
                .doAfterNext(s -> System.out.println("1: " + Thread.currentThread().getName() + " => " + s))
                .subscribeOn(Schedulers.computation()) // não importa a posição
                .subscribe(s -> System.out.println("2: " + Thread.currentThread().getName() + " => " + s));

        try {
            TimeUnit.MILLISECONDS.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

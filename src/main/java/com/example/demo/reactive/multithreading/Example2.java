package com.example.demo.reactive.multithreading;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example2 {

    public static void main(String[] args) {
        //old();
        moderno();
    }

    private static void moderno() {
        ParallelFlowable src = Flowable.fromArray("one", "two", "three").parallel();
        src.runOn(Schedulers.computation())
                .doAfterNext(s -> System.out.println("1: " + Thread.currentThread().getName() + " => " + s))
                .flatMap(w -> Flowable.fromArray(((String)w).split("")))
                .runOn(Schedulers.computation())
                .doAfterNext(s -> System.out.println("2: " + Thread.currentThread().getName() + " => " + s))
                .sequential()
                .subscribe(s -> System.out.println("3: " + s));

        try {
            TimeUnit.MILLISECONDS.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void old() {
        Observable.fromArray("one", "two", "three")
                .observeOn(Schedulers.computation())
                .doAfterNext(s -> System.out.println("1: " + Thread.currentThread().getName() + " => " + s))
                .flatMap(w -> Observable.fromArray(w.split(""))
                .observeOn(Schedulers.computation())
                .doAfterNext(s -> System.out.println("2: " + Thread.currentThread().getName() + " => " + s)))
        .subscribe(s -> System.out.println(s));

        try {
            TimeUnit.MILLISECONDS.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

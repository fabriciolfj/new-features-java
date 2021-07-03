package com.example.demo.v1.reactive.operadores;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import java.util.concurrent.TimeUnit;

public class Exemplo1 {

    public static void main(String[] args) {
        new Exemplo1().create();
    }

    private void create() {
        ObservableOnSubscribe<String> source = observableEmitter -> {
            observableEmitter.onNext("one");
            observableEmitter.onNext("two");
        };

        Observable.create(source)
                .filter(f -> f.contains("w"))
                .subscribe(
                        v -> System.out.println(v),
                        e -> e.printStackTrace(),
                        () -> System.out.println("complete"));

        pauseMs(100L);
    }

    void pauseMs(Long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.reactive.utilities;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        new Example1().delay();
        new Example1().range();
    }

    private void range() {
        Observable source = Observable.range(1,5);
        Disposable disposable = source.subscribe();

        Observable.using( // consumo o observable e decarto ao concluir, similar ao try-with-resources
                () -> disposable,
                x -> source, // consumo o observable
                y -> System.out.println("Disposed: " + y) // se ele foi discartado ou nao
        ).delay(10, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        pauseMs(25L);
    }

    private void delay() {
        Observable<String> obs = Observable.just("one")
                .flatMap(s -> Observable.fromArray(s.split("")));

        obs.delay(5, TimeUnit.MILLISECONDS)
                .subscribe(System.out::print);

        pauseMs(10L);
    }

    void pauseMs(Long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

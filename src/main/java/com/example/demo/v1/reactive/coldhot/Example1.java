package com.example.demo.v1.reactive.coldhot;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        new Example1().hotBackPressure();
    }

    //PublishProcessor extend Flowable, que possui controle de contra pressão
    private void hotBackPressure() {
        PublishProcessor<Integer> hot = PublishProcessor.create();
        hot.onBackpressureDrop(v -> System.out.println("Dropped: " + v)) // caso o número de emissão seja maior que o tempo de vazao, feita pelo processamento,
                // os dados que não conseguirem serem processados, seram descartados.
                .observeOn(Schedulers.io(), true)
                .subscribe(System.out::println, Throwable::printStackTrace);

        for(int i = 0; i < 1_000_000; i ++) {
            hot.onNext(i);
        }
    }

    private void hot() {
        ConnectableObservable<Long> hot = Observable.interval(10, TimeUnit.MILLISECONDS).publish();
        hot.connect();
        hot.subscribe(i -> System.out.println("First: " + i));
        hot.subscribe(i -> System.out.println("Second: " + i));
        pauseMs(55L);
    }

    private void cold() {
        Observable<Long> cold = Observable.interval(10, TimeUnit.MILLISECONDS);
        cold.subscribe(i -> System.out.println("First: " + i));
        cold.subscribe(i -> System.out.println("Second: " + i));
        pauseMs(55L);
    }

    void pauseMs(Long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

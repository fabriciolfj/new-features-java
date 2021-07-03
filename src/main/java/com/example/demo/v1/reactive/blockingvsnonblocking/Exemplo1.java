package com.example.demo.v1.reactive.blockingvsnonblocking;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Exemplo1 {

    public static void main(String[] args) {
        Observable<Integer> obs = Observable.range(1, 5);

        //block
        Double d2 = obs.filter(i -> i % 2 == 0)
                .doOnNext(System.out::println)
                .map(Math::sqrt)
                .delay(100, TimeUnit.MILLISECONDS)
                .blockingLast();

        System.out.println(d2);

        //non-blocking
        List<Double> list = new ArrayList<>();
        obs.filter(i -> i % 2 == 0)
                .doOnNext(System.out::println)
                .map(Math::sqrt)
                .delay(100, TimeUnit.MILLISECONDS)
                .subscribe(d -> {
                    if(list.size() == 1) {
                        list.remove(0);
                    }

                    list.add(d);
                });

        try{
             TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }
}

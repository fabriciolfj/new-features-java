package com.example.demo.reactive.filter;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        Observable<String> obs = Observable.just("onetwo")
                .flatMap(s -> Observable.fromArray(s.split("")));
        //obs emits onetwo as characteres

        System.out.println("============ debounce");
        obs.map(s -> {
            if("t".equals(s)) {
                TimeUnit.MILLISECONDS.sleep(50);
            }

            return s;
        }).debounce(10, TimeUnit.MILLISECONDS) // somente emite um item de um Observable se um período de tempo
                // específico tiver passado sem que ele emita outro item
                .forEach(System.out::println);

        System.out.println("============");
        obs.distinct().forEach(System.out::println);

        System.out.println("============");
        obs.elementAt(3).subscribe(System.out::println); // pegar o 3 item

        System.out.println("============");
        obs.filter(s -> s.equals("o"))
                .forEach(System.out::println);

        System.out.println("============");
        obs.firstElement().subscribe(System.out::println);

        new Example1().interval();

    }

    private void interval() {
        System.out.println("============");
        Observable.interval(5, TimeUnit.MILLISECONDS)
                .sample(10, TimeUnit.MILLISECONDS) // vai emitir o valor mais recente emitido dentro de um intervalo de tempo especificado.
                .subscribe(v -> System.out.println(v + " "));

        pauseMs(50L);
    }

    void pauseMs(Long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.v1.reactive.backpressure;

import io.reactivex.Flowable;

public class Example1 {

    public static void main(String[] args) {
        Flowable<Double> obs = Flowable.fromArray(1.,2.,3.);
        obs.onBackpressureBuffer().subscribe(); //definio um tamanho do meu buffer para fazer contra pressão

        obs.onBackpressureLatest().subscribe(); // digo ao produtor para pausar, quando o consumir não processar o valores emitidos a tempo.
    }
}

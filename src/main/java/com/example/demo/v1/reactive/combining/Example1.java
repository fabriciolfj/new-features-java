package com.example.demo.v1.reactive.combining;

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.concurrent.TimeUnit;

public class Example1 {

    public static void main(String[] args) {
        Observable<String> obs1 = Observable.just("one")
                .flatMap(s -> Observable.fromArray(s.split("")));

        Observable<String> obs2 = Observable.just("two")
                .flatMap(s -> Observable.fromArray(s.split("")));

        Observable.concat(obs2, obs1, obs2)
                .subscribe(System.out::println);


        System.out.println("===========================================");

        Observable.combineLatest(obs2, obs1, (x,y) -> "("+x+y+")").subscribe(System.out::println); // pega a ultimo caracter de obs2, e combina com cada um de obs1

        System.out.println("===========================================");

        obs1.join(obs2, i -> Observable.timer(5, TimeUnit.MILLISECONDS), i -> Observable.timer(5, TimeUnit.MILLISECONDS)
                , (x, y) -> "("+x+y+")").subscribe(System.out::println);
        // para cada caracter de ob1, será combinado com todos os caracters de obs2, tipo: ot, nt, et

        System.out.println("===========================================");
        Observable.merge(obs2, obs1, obs1)
                .subscribe(System.out::println); //simular ao concact, mas intercala os valores

        System.out.println("===========================================");
        obs1.startWith("42")
                .subscribe(System.out::println); // cola 42 antes do evento

        System.out.println("===========================================");
        Observable.zip(obs1, obs2, obs1, (x,y,z) -> "("+x+y+z+")").subscribe(System.out::print);
        // combina os valores com base em uma funcao fornecida, nesse caso vai combinar o primeiro event, oto, segundo evento nwn e assim por diante
    }
}

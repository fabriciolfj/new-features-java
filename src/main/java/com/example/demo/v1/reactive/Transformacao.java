package com.example.demo.v1.reactive;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.List;

public class Transformacao {

    public static void main(String[] args) {
        Observable<String> obs = Observable.fromArray("one", "two");
        obs.map(s -> s.contains("w")? 1 :0)
                .forEach(System.out::println);

        List<String> os = new ArrayList<>();
        List<String> noto = new ArrayList<>();
        obs.flatMap(s -> Observable.fromArray(s.split("")))
                .groupBy(s -> "o".equals(s)? "o": "noto")
                .subscribe(g -> g.subscribe(s -> {
                    if(g.getKey().equals("o")) {
                        os.add(s);
                    }else{
                        noto.add(s);
                    }
                }));

        System.out.println(os);
        System.out.println(noto);
    }
}

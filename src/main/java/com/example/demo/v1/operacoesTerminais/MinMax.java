package com.example.demo.v1.operacoesTerminais;

import com.example.demo.v1.model.Person;

import java.util.Arrays;
import java.util.Comparator;

public class MinMax {

    public static void main(String[] args) {
        var persons = Arrays.asList(
                new Person(10, "Fabricio"),
                new Person(14, "Lucas"),
                new Person(5, "Ferraz"),
                new Person(30, "Bruno")
        );

        Comparator<Person> perComp = (p1, p2) -> p1.getAge() - p2.getAge();

        Person old = persons.stream()
                .max(perComp)
                .orElse(null);

        Person new1 = persons.stream()
                .min(perComp)
                .orElse(null);

        System.out.println(old);
        System.out.println(new1);
    }
}

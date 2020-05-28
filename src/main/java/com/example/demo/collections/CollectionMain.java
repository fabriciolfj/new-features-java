package com.example.demo.collections;

import com.example.demo.model.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionMain {

    private List<Person> persons = Arrays.asList(
            new Person(10, "Fabricio"),
            new Person(14, "Lucas"),
            new Person(5, "Ferraz"),
            new Person(30, "Bruno")
    );

    public static void main(String[] args) {
        List<String> ls = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

        System.out.println(ls);

        Set<String> set = Stream.of("a", "b", "c")
                .collect(Collectors.toSet());

        System.out.println(set);

        new CollectionMain().map();

    }

    private void hasSet() {
        Set<Person> personSet = persons.stream()
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(personSet);
    }

    private void map() {
        Map<String, Person> map = persons.stream()
                .collect(Collectors.toMap(p -> p.getFirstName() + "-" + p.getAge(), p -> p));

        System.out.println(map);

    }
}

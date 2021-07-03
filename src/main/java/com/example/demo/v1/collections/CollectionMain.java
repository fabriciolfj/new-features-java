package com.example.demo.v1.collections;

import com.example.demo.v1.model.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
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
        new CollectionMain().hasSet();
        new CollectionMain().joining();
        new CollectionMain().sum();
        new CollectionMain().summary();
        new CollectionMain().partitionBy();
        new CollectionMain().groupingBy();

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

    private void sum() {
        int sum = persons.stream().collect(Collectors.summingInt(Person::getAge));
        System.out.println(sum);
    }

    private void joining() {
        List<String> list1 = List.of("a", "b", "c", "d");
        String result = list1.stream()
                .collect(Collectors.joining());
        System.out.println(result);

        result = list1.stream().collect(Collectors.joining(", "));
        System.out.println(result);

        result = list1.stream()
                .collect(Collectors.joining(", ", "The result:", ""));
        System.out.println(result);
    }

    private void summary() {
        IntSummaryStatistics stats = persons.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println(stats);
    }

    private void partitionBy() {
        Map<Boolean, List<Person>> map2 = persons
                .stream()
                .collect(Collectors.partitioningBy(p ->p.getAge() > 24));

        System.out.println(map2);
    }

    private void groupingBy() {
        Map<Integer, List<Person>> map = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(map);
    }
}

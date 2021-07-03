package com.example.demo.v1.operacoesTerminais;

import com.example.demo.v1.model.Person;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

    private List<Person> list = Arrays.asList(
            new Person(23, "Bod"),
            new Person(33, "Jim"),
            new Person(28, "Jill"),
            new Person(27, "Bill"),
            new Person(15, "Test"));

    public static void main(String[] args) {
        List<String> list = Stream.of("1", "2", "3")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(list);

        new Collect().usoCombineAcumulador();
    }

    private void foreach() {
        var path = Paths.get("src/main/resources/persons.csv");
        try(Stream<String> lines = Files.newBufferedReader(path).lines()) {
            var persons = lines.filter(s -> s.contains("J"))
                    .map(s -> s.split(","))
                    .map(this::mappeToPerson)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Person mappeToPerson(String[] arr) {
        int age = Integer.valueOf(StringUtils.remove(arr[0], ' '));
        return new Person(age, StringUtils.remove(arr[1], ' '));
    }

    private void usoCombineAcumulador() {

        BiConsumer<Person, Person> accumulator = (p1, p2) -> {
            if(p1.getAge() < p2.getAge()) {
                p1.setAge(p2.getAge());
                p1.setFirstName(p2.getFirstName());
            }
        };

        BiConsumer<Person, Person> combiner = (p1, p2) -> {
            if(p1.getAge() < p2.getAge()) {
                p1.setAge(p2.getAge());
                p1.setFirstName(p2.getFirstName());
            }
        };

        Person old = list.stream()
                .collect(Person::new, accumulator, combiner);

        System.out.println(old);

    }
}

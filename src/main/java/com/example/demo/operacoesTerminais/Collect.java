package com.example.demo.operacoesTerminais;

import com.example.demo.model.Person;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collect {

    public static void main(String[] args) {
        List<String> list = Stream.of("1", "2", "3")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(list);

        new Collect().foreach();
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
}

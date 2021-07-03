package com.example.demo.v1.consumer;

import com.example.demo.v1.model.Person;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        String externalData = "external data";
        Consumer<Person> setRecord = p -> p.setRecord(p.getFirstName() + " " + p.getLasName() + ", " + p.getAge() + ", " + externalData);
        Consumer<Person> printRecord = p -> System.out.println(p.getRecord());
        Consumer<Person> setRecordThenPrint = setRecord.andThen(printRecord);
        setRecordThenPrint.accept(new Person(42, "Nick", "Teste"));

        Consumer<String> print = s -> System.out.println("Resultado: " + s);
        print.accept("10.0");
    }
}

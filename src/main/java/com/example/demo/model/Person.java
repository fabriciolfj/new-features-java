package com.example.demo.model;

public class Person {
    private int age;
    private String firstName, lasName, record;

    public Person(int age, String firstName, String lasName) {
        this.age = age;
        this.firstName = firstName;
        this.lasName = lasName;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public String getRecord() {
        return record;
    }
}

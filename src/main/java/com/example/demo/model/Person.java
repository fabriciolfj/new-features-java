package com.example.demo.model;

public class Person {
    private int age;
    private String firstName, lasName, record;

    public Person() {

    }

    public Person(int age, String firstName, String lasName) {
        this.age = age;
        this.firstName = firstName;
        this.lasName = lasName;
    }

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
        this.lasName = "nothing";
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lasName='" + lasName + '\'' +
                ", record='" + record + '\'' +
                '}';
    }
}

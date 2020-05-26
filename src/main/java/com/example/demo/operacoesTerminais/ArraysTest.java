package com.example.demo.operacoesTerminais;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysTest {

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        String [] str = list.toArray(new String[list.size()]);
        List<String> strList = Arrays.stream(str).collect(Collectors.toList());
        strList.forEach(System.out::println);
    }
}

package com.example.demo.v1.operacoesTerminais;

import java.util.List;

public class FindAnyFirst {

    public static void main(String[] args) {
        var list = List.of("1", "2", "3", "4", "5");

        System.out.println(list.stream().filter(e -> "3".equals(e)).findAny().get()); // se encontrar retorna qualquer um
        System.out.println(list.stream().filter(e -> "5".equals(e)).findFirst().get()); // se encontrar, retorna o mesmo ou o primeiro caso esteja duplicado
    }
}

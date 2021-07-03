package com.example.demo.v1.operacoesTerminais;

import java.util.List;

public class MatchAllAnyNone {

    public static void main(String[] args) {
        var list = List.of("1", "2", "3", "4", "5");

        System.out.println(list.stream().anyMatch(e -> "3".equals(e))); // se apenas 1 corresponder a função retorna true
        System.out.println(list.stream().noneMatch(e -> "9".equals(e))); // se nenhum dos elementos corresponderem a função retorna true
        System.out.println(list.stream().allMatch(e -> "3".equals(e))); // se todos os elementos corresponderem a função retorna true
    }
}

package com.example.demo.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Double> multiplyByTen = i -> i * 10.0;
        System.out.println(multiplyByTen.apply(3));

        Supplier<Integer> supply7 = () -> 7;
        Consumer<String> printResult =s -> System.out.println("Result: " + s);
        printResult.accept(multiplyByTen.apply(supply7.get()).toString());

        //Function<Entrada,Saida>
        Function<Double, Long> divideByTwo = d -> Double.valueOf(d / 2).longValue();
        Function<Long, String> incrementAndCreateString = l -> String.valueOf(l + 1);
        /**quando junto 2 functions a entrada é igual a entrada da funcao antes do andThen, e a saida tem que ser igual a saida da funcao dentro do andthen
         * */
        Function<Double, String> divideByTwoIncrementAndCreateString = divideByTwo.andThen(incrementAndCreateString);
        printResult.accept(divideByTwoIncrementAndCreateString.apply(4.0));
    }
}

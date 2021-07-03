package com.example.demo.v1.operacoesTerminais;

import com.example.demo.v1.model.Person;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

    private List<Person> persons = Arrays.asList(
            new Person(10, "Fabricio"),
            new Person(14, "Lucas"),
            new Person(5, "Ferraz"),
            new Person(30, "Bruno")
    );

    private List<Integer> ints = List.of(1,2,3);

    public static void main(String[] args) {
        //new ReduceDemo().findOldPerson();
        //new ReduceDemo().groupNames();
        new ReduceDemo().somas();
    }

    private void somas() {
        int sum = ints.stream().reduce((v1, v2) ->  v2 + v1).orElse(0);
        System.out.println(sum);

        int sum2 = ints.stream().reduce(Integer::sum).orElse(0);
        System.out.println(sum2);

        int sum3 = ints.stream().reduce(10,Integer::sum);
        System.out.println(sum3);

        int sum4 = ints.stream().reduce(10, Integer::sum, Integer::sum);
        System.out.println(sum4);

        int sum5 = ints.parallelStream().reduce(Integer::sum).orElse(0);
        System.out.println(sum5);

        int sum6 = ints.parallelStream().reduce(10, Integer::sum);
        System.out.println(sum6);

        // tem o mesmo efeito com string, no entanto ele vai somar 10 a cada subsequencia que gerar
        int sum7 = ints.parallelStream().reduce(10, Integer::sum, Integer::sum);
        System.out.println(sum7);

        int sum8 = ints.parallelStream().reduce(0, Integer::sum, Integer::sum);
        System.out.println(sum8);
    }

    private void groupNames() {
        //reduce com valor inicial ou de identidade All names
        var names = persons
                .stream()
                .map(n -> n.getFirstName())
                .reduce("All names: ", (p1, p2) -> p1 + " , " + p2);

        System.out.println(names);

        //com o terceiro parâmetro, o comparador, o resultado não muda em um fluxo não paralelo
        var names2 = persons
                .stream()
                .map(n -> n.getFirstName())
                .reduce("All names: ", (p1, p2) -> p1 + " , " + p2, (p1, p2) -> p1 + " , " + p2);

        System.out.println(names2);

        //ja um paralelo muda o resultado
        var names3 = persons
                .parallelStream()
                .map(n -> n.getFirstName())
                .reduce("All names: ", (p1, p2) -> p1 + " , " + p2, (p1, p2) -> p1 + " , " + StringUtils.remove(p2, "All names: "));

        System.out.println(names3);
    }

    private void findOldPerson() {
        Person old = persons
                .stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge()? p1 : p2)
                .orElse(null);

        System.out.println(old);

    }
}

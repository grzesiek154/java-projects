package com.company.my.poc.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeMain {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.Male),
                new Person("Anna", Gender.Female)
        );

        //imperative approach
        System.out.println("imperative approach");
        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();

        for (Person person : people) {
            if(Gender.Female.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person person : females) {
            if(Gender.Female.equals(person.gender)) {
                System.out.println("Female found: " + person.name);
            }
        }

        //declarative approach
        System.out.println("Declarative approach");
        people.stream().filter(person -> Gender.Female.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum Gender {
        Male, Female
    }
}

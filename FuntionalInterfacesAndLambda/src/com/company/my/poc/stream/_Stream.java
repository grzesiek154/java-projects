package com.company.my.poc.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import static com.company.my.poc.stream._Stream.Gender.MALE;
import static com.company.my.poc.stream._Stream.Gender.FEMALE;
import static com.company.my.poc.stream._Stream.Gender.PREFER_NOT_TO_SAY;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        // this is how stream look wit functional interaces
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        people.stream().map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        boolean containsOnlyFemale = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        boolean containsOnlyFemale2 = people.stream().noneMatch(personPredicate);

        System.out.println(containsOnlyFemale);
        System.out.println(containsOnlyFemale2);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}

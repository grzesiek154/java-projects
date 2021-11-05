package com.company.my.poc.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

public class Practice1 {

    public static void main(String[] args) {
        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam") + " - should be 14");
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");

        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> people = asList(sara, eva, viktor);
        System.out.println(getOldestPerson(people).getAge());
        transform(collection).forEach(name -> System.out.println(name));

    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {

        int numOfLetters  = stream(names).filter(name -> name.length() > 5).mapToInt(name -> name.length()).sum();
        return numOfLetters;
    }

    //Flatten this multidimensional collection
    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        newCollection = collection.stream().flatMap(Collection::stream).collect(Collectors.toList());


        return newCollection;
    }

    //Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
    public static int calculate(List<Integer> numbers) {
        int total = 0;
        total = numbers.stream().reduce((val, acc) -> acc+=val).get();
        return total;
    }

    //Get the oldest person from the collection
    public static Person getOldestPerson(List<Person> people) {
        Person oldestPerson = new Person("", 0);
        oldestPerson = people.stream().max(Comparator.comparing((Person::getAge))).get();
        return oldestPerson;
    }
}

package com.company.my.poc.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Practice2 {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        Person anna = new Person("Anna", 5, "Poland");
        List<Person> collection = Arrays.asList(sara, eva, viktor, anna);
        Map<String, List<Person>> groupedByNationality = groupByNationality(collection);

        getKidNames(collection).forEach(System.out::println);
        List<Person> adults = partitionAdults(collection).get(true);
        List<Person> young = partitionAdults(collection).get(false);

        adults.forEach(person -> System.out.println("adult: " + person.getName()));
        young.forEach(person -> System.out.println("not adult: " + person.getName()));
        for (Map.Entry<String, List<Person>> entry : groupedByNationality.entrySet()) {
            System.out.println("Country: " + entry.getKey() + ",\n" +  "Names: ");
            entry.getValue().forEach(person -> System.out.println(person.getName()));
        }
    }

    //Get the names of all kids under the age of 18
    public static Set<String> getKidNames(List<Person> people) {
        Set<String> kids = new HashSet<>();
        kids = people.stream().filter(person -> person.getAge() < 18).map(person -> person.getName()).collect(Collectors.toSet());
        return kids;
    }

    //Partition these people into adults and kids, you'll need a special collector for this one
    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());

        map = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 18));

        return map;
    }

    //Group these people by nationality, same kind as the previous exercise
    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        map = people.stream().collect(Collectors.groupingBy(person -> person.getNationality()));
        return map;
    }
}

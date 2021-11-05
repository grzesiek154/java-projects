package com.company.my.poc.inteviews_challenge;

import java.util.List;
import java.util.stream.Collectors;

public class Interview {



    public static void main(String[] args) {
        List<String> names = List.of("Adam", "Ewa", "Ola", "Grzegorz", "Arkadiusz");
        List<String> newNames = names.stream().filter(name-> name.length() > 5).map(name-> name.toUpperCase()).limit(3).collect(Collectors.toList());
    }

    // checked and uncheck exceptions
    // find any, find first
    // static factory
    // threads and atomic integer
    // stop the world GC
    // compare to vs equals
    // hash map and few objects with the same has code , equals usage
    // equals contract
    // builder pattern and mandatory fields
    // exceptions in java
    // sql questions

}

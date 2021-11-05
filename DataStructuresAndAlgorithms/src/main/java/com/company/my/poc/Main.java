package com.company.my.poc;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LocalDateTime startDate = LocalDateTime.of(2021,10,10,0,0);
        LocalDateTime endDate = LocalDateTime.of(2021,10,17,10,0);

        System.out.println(endDate.compareTo(startDate));
    }
}

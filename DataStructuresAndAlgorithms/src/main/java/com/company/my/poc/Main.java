package com.company.my.poc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here

    String date1= "10/11/2021";
    String date2= "15/11/2021";
    String country = "FR_Paris";

        System.out.println(country.startsWith("FR_"));

        try {
            System.out.println(getDaysDiff(date1, date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static long getDaysDiff(String from, String to) throws ParseException {
        Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(from);
        Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(to);
        long diff = Math.abs(fromDate.getTime() - toDate.getTime());

        return (diff / (60*60*24*1000));
    }
}

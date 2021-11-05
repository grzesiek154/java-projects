package com.company.my.poc.inteviews_challenge;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("a", 1000000000000L));
        System.out.println(repeatedString("aba", 1000000000000L));
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        char[] stringArray = s.toCharArray();
        int index = 0;
        Long counter = 0L;

        if(s == "a") {
            counter = n;
        } else {
            for (int i = 0; i < n; i++) {
                if (stringArray[index] == 'a') {
                    counter++;
                }
            }
        }
        return counter;
    }
}

package com.company.my.poc.inteviews_challenge;

public class CountingValleys {

    public static void main(String[] args) {
        System.out.println("1: " + countingValleys(8, "UDDDUDUUU"));//1
        System.out.println("2: " + countingValleys(12, "DDUUDDUDUUUD"));//2
        System.out.println("3: " + countingValleys(10, "UDUUUDUDDD"));//0



    }
/**
    IF seaLevel IS -1 AND char IS 'D'
        INCREMENT valley AND
        DECREMENT seaLevel
    ELSE IF char IS  'U'
        INCREMENT seaLevel
    ELSE IF char IS
**/

public static int countingValleys(int steps, String path) {

    int valleys = 0;
    int seaLevel = 0;

    for(char step: path.toCharArray()) {
        if(step == 'U') seaLevel++;
        if(step == 'D') seaLevel--;

        if(seaLevel == 0 && step == 'U') {
            valleys++;
        }
    }
    return valleys;
}



}

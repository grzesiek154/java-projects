package com.company.my.poc.inteviews_challenge;

import java.util.List;

public class JumpingClouds {

    public static void main(String[] args) {
        List<Integer> clouds = List.of(0,0,1,0,0,1,0);
        List<Integer> clouds2 = List.of(0,0,0,0,1,0);
        List<Integer> clouds3 = List.of(0,0,0,1,0,0);
        List<Integer> clouds4 = List.of(0,1,0,0,0,1,0);
        System.out.println(jumpingOnClouds(clouds)); //4
        System.out.println(jumpingOnClouds(clouds2)); // 3
        System.out.println(jumpingOnClouds(clouds3)); // 3
        System.out.println(jumpingOnClouds(clouds4)); // 3
    }

    //working solution
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here

        int steps = 0;
        int index = 0;

        while (index < c.size() - 1) {
            if (index + 2 < c.size() && c.get(index + 2) == 0) {
                steps++;
                index = index + 2;
            } else if (index + 1 < c.size() && c.get(index + 1) == 0) {
                steps++;
                index = index + 1;
            }
        }
        return steps;
    }

    public static int jumpingOnClouds2(List<Integer> c) {
        // Write your code here
        int index = 0;
        int jump = 0;
        if (c.get(index + 2) == 0) {
            jump = 2;
        } else if (c.get(index + 1) == 0) {
            jump = 1;
        }
        return 0 + jumpingOnClouds2(c.subList(index + jump, c.size() - 1));
    }
}

package com.company.my.poc.inteviews_challenge.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    //loop through all nums
    // check if we substract a particular num from target (reminder), exist other num which equals reminder
    // than add two indexes to result array
    public static void main(String[] args) {
        int[] test1 = new int[]{2,7,11,15};
        System.out.println(twoSum(test1,9)[0]);
        System.out.println(twoSum(test1,9)[1]);
    }


    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int reminder = target - nums[i];
            if (map.containsKey(reminder)) {
                return new int[]{i, map.get(reminder)};
            }
        }
        return null;
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] resultArray = new int[2];

        for(int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    resultArray = new int[]{i, j};
                }
            }
        }
        return resultArray;
    }
}

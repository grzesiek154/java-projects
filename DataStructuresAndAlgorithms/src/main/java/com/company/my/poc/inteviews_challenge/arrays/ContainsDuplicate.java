package com.company.my.poc.inteviews_challenge.arrays;

import java.util.Arrays;

public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public static boolean containsDuplicate(int[] nums) {
        boolean isDuplicatedValue = false;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i]== nums[i+1]) {
                isDuplicatedValue = true;
                break;
            }
        }
        return isDuplicatedValue;
    }
}

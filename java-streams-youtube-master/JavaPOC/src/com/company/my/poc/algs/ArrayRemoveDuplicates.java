package com.company.my.poc.algs;

import java.util.Arrays;

public class ArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] expectedNums;
        int[] nums = {2,4,3,2,4,1,3,1};

        System.out.println(removeDuplicates(nums));
    }


    public static int removeDuplicates(int[] nums) {
        int k = 1;
        nums = bubbleSort(nums);
        int[] nums2 = nums;
        int iter = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1]) {
                k++;
                nums2[iter] = nums[i];
                nums[iter] = nums[i];
                iter++;
            }
//            else {
//                nums[nums.length - i] = nums[i];
//                iter++;
//            }
        }
        System.out.println("remove duplicates");
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("nums2");
        Arrays.stream(nums2).forEach(System.out::println);
         return k;
    }

    public static int[] bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println("Ordered array");
        Arrays.stream(array).forEach(System.out::println);
        return array;
    }
}

package com.company.my.poc.inteviews_challenge.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int array1[] = {1,2,3,4};
        Arrays.stream(productExceptSelf(array1)).forEach(System.out::println);
        Arrays.stream(productExceptSelf2(array1)).forEach(System.out::println);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] productArray = new int[nums.length];
        Arrays.fill(productArray,1);
        productArray[0] = 1;
        for (int i = 0; i < nums.length; i++) {
           for (int j = 0; j < nums.length; j++) {
               if (i != j) {
                   productArray[i] *= nums[j];
               }
           }
        }
        return productArray;
    }

    public static int[] productExceptSelf2(int[] nums) {
        //explanation https://leetcode.com/problems/product-of-array-except-self/discuss/135882/A-Java-solution-with-an-explanation

        // Left is an array containing the left products
        // i.e: left[i] = nums[0] * .... * nums[i-1]  * nums[i]
        int[] left = new int[nums.length];

        // Right is an array containing the array products
        //i.e: right[i] = nums[i] * nums[i+1]  * .... * nums[len(nums)]
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < product.length; i++) {
            product[i] = left[i] * right[i];
        }

        return product;
    }
}

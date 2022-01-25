package com.company.my.poc.inteviews_challenge.string;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {

//        Algorithm
//        We could see that the longest common substring method fails when there exists a reversed copy of a non-palindromic substring in some other part of SSS. To rectify this, each time we find a longest common substring candidate, we check if the substring’s indices are the same as the reversed substring’s original indices. If it is, then we attempt to update the longest palindrome found so far; if not, we skip this and find the next candidate.

        String reversed = new StringBuilder(s).reverse().toString();
        char[] reversedArr = reversed.toCharArray();
        char[] stringArr = s.toCharArray();
        String longestPalindrome = new StringBuilder().append(stringArr[0]).toString();
        String tempLongestPalindrome = "";
        for (int i = 0; i < reversed.toCharArray().length; i++) {
            if (reversedArr[i] == stringArr[i]) {
                tempLongestPalindrome += reversedArr[i];
            } else {
                tempLongestPalindrome = "";
            }
            // case where palindrome is always equals to firs letter
            if (longestPalindrome.length() < tempLongestPalindrome.length()) {
                longestPalindrome = tempLongestPalindrome;
            }
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {

//        System.out.println(longestPalindrome("test"));
//        System.out.println(longestPalindrome("kajak"));
//        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("abb"));
    }
}


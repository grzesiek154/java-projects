package com.company.my.poc.inteviews_challenge.string;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));


    }
    public static int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        //iterate through a string
        //check each char
        //IF current char and next char are different
        //add those to the tempLongestString
        //IF currentChar == next char
        //longestString = tempLongestString

        char[] s_array = s.toCharArray();
        String longestString = "";
        String tempLongestString = "";
        for (int i = 0; i < s_array.length-1; i++) {
            if(s_array[i] != s_array[i+1]) {
                tempLongestString += s_array[i];
            } else if (s_array[i] == s_array[i+1]) {
                longestString = tempLongestString;
            } else if (tempLongestString.length() > longestString.length()) {
                longestString = tempLongestString;
            }
        }

        return longestString.length();
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] s_array = s.toCharArray();
        String longestString = "";
        String tempLongestString = "";
        for (int i = 0; i < s_array.length-1; i++) {

        }

        return 0;
    }
}

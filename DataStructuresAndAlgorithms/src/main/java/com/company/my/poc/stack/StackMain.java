package com.company.my.poc.stack;

public class StackMain {

    public static void main(String[] args) {
        Stack theStack = new Stack(3);
        System.out.println(reverseString("test"));
    }

    public static String reverseString(String str) {
        int stackSize = str.length();
        Stack theStack = new Stack(stackSize);

        for(int i = 0; i < str.length(); i++) {
            theStack.push(str.charAt(i));
        }
        String result = "";
        while (!theStack.isEmpty()) {
            result = result + theStack.pop();
        }

        return result;
    }


}

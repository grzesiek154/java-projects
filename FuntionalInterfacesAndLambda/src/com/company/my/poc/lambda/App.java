package com.company.my.poc.lambda;

public class App {


    public static void main(String[] args) {
        walker(() -> System.out.println("walker walks"));
        ALambdaInterface aLambdaInterface = () -> System.out.println("walker walks");

    }


    public static void walker(Walkable walkable) {
        walkable.walk();
    }
}

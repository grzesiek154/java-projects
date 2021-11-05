package com.company.my.poc.functionalInterace;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment  = incrementByOne(1);
        System.out.println(increment);

        //function chaining
        Integer increment2 = incrementByOneFunction.apply(1);
        Integer multiply = multipleBy10.apply(increment2);
        System.out.println(multiply);
        System.out.println(addBy1AnThenMultiplyBy10.apply(1));

    }

    static int incrementByOne(int number) {
        return number + 1;
    }
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multipleBy10 = number -> number * 10;
    static Function<Integer, Integer> addBy1AnThenMultiplyBy10 = incrementByOneFunction.andThen(multipleBy10);

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
    BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyFunction =
        (number, numToMultiplyBy) -> (number + 1) * numToMultiplyBy;



}

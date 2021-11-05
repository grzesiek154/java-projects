package com.company.my.poc;

import java.util.Set;
import java.util.function.Supplier;

public class A  implements Ship{

    public A() {
    }
    static void transform(Supplier<Set<String>> test) {
        System.out.println("test");
    }

    @Override
    public void go() {
        System.out.println("sea surface");
    }
}

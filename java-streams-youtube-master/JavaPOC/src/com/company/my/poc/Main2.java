package com.company.my.poc;

import java.util.Collections;
import java.util.HashSet;

public class Main2 {



    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        A.transform(Collections::emptySet);
        A.transform(HashSet::new);
        A.transform(HashSet<String>::new);


        A submarine = new A();
        ((B) submarine).go();
    }
}

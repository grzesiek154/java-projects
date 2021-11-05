package com.company.my.poc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List testNums = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        List testNums2 = List.of(1, 1, 3, 1, 2, 1, 3, 3, 3, 3);
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list1.addAll(testNums);
        list2.addAll(testNums2);
        int socks = 14;
        System.out.println(socks / 2);
        System.out.println(socks % 2);
        sockMerchant(list2.size(), list2);
        System.out.println("size: " + list2.size());
    }

    public static int sockMerchant(int n, List<Integer> ar) {
//        // Write your code here
        int pairsCounter = 0;
//        // loop throug all arr elements
//        // check if arr[n] value is present appears again
//        // if there is a match increase parisCounter
//        // how to prevent form checking sock which was already check

        for (int i = 0; i < n; i++) {
            if(ar.get(i) != 0) {
                for (int j = i + 1; j < n - 1; j++) {
                    if (ar.get(i) == ar.get(j)) {
                        ar.set(j, 0);
                        pairsCounter++;
                        break;
                    }
                }
            }
        }


//        Set<Integer> socks = new HashSet();
//        for (int i = 0; i < n; i++) {
//            if(!socks.contains(ar.get(i))) {
//                socks.add(ar.get(i));
//
//            } else {
//                pairsCounter++;
//                socks.remove(ar.get(i));
//            }
//
//        }
        System.out.println("pairsCounter: " + pairsCounter);
        return pairsCounter;
    }
}



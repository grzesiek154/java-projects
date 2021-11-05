package com.company.my.poc;

import java.util.Arrays;
import java.util.List;


public class Main {



    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        List<Integer> stocks = List.of(100,20,10,30,55,40,50);
        // first buy then sell
        // roznica


        System.out.println(findHighestDiff(stocks));
    }

     static int findHighestDiff(List<Integer> stocks) {
        int maxDiff = 0;
        for (int i = 0; i < stocks.size(); i++) {
            int buy = stocks.get(i);
            for(int j = i + 1; j < stocks.size(); j++) {
               int diff = stocks.get(j) - buy;
                if(diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return maxDiff;
     }


    private void start()
    {
        List<Pair> pairs = Arrays.asList(
                new Pair(1, 6), new Pair(2, 2), null, new Pair(2, 3)
        );
        int sum = this.calculatePairSum(pairs);
        System.out.println("Sum: " + sum);
    }

    private int calculatePairSum(List<Pair> pairs)
    {
        // suma wartosci dla par ktorych klucze sa wieksze niz 5
       return pairs.stream().filter(pair -> pair != null && pair.getKey() > 5).map(pair -> pair.getValue()).reduce((val, acc) -> val+acc).orElseGet(() -> 0);

    }
}

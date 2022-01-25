package com.company.my.poc.inteviews_challenge.arrays;

public class BestTimeToBuyOrSellStock {

    public static void main(String[] args) {

        //System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,6,4,3,1}));
    }
    public static int maxProfit(int[] prices) {
        // price[i] - pricje[i+1]
        int bestPrice = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int currentPrice = prices[j] - prices[i];
                if (currentPrice > bestPrice) {
                    bestPrice = currentPrice;
                }
            }
        }
        return bestPrice;
    }

    public static int maxProfit2(int[] prices) {
        // price[i] - pricje[i+1]
        int bestPrice = 0;
        int minPrice  = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <  minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > bestPrice) {
                bestPrice = prices[i] - minPrice;
            }
        }
        return bestPrice;
    }

}

package org.example.vic.leetcode;

public class T121 {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}

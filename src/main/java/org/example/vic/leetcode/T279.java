package org.example.vic.leetcode;

import java.util.Arrays;

public class T279 {
    /**
     * 完全平方数 动态规划
     *
     * @param n 待分割的数
     * @return 最少由几个完全平方数构成
     */
    public int numSquares(int n) {
        // dp[i]表示数字i最少可由几个完全平方数相加构成
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            // 由平方数组成所以子问题范围一定在根号i内
            for (int j = 1; j * j <= i; ++j) {
                // i位置以来的是i-j*j位置的dp值，检索完，哪个dp值最小，就记录哪个
                // i-1 i-4 i-9 ...
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}

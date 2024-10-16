package org.example.vic.leetcode;

import java.util.Arrays;

/**
 * T322
 *
 * @author vic
 * @since 2024-10-16
 */
public class T322 {
    /**
     * 零钱兑换 完全背包
     *
     * @param coins 硬币数组
     * @param amount 待组成的金额
     * @return 最少需要多少硬币
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                // 组成i时，需要加当前硬币
                if (i >= coin) {
                    // dp[i]: 组成i金额时，最少需要的硬币数
                    // dp[i - coin] + 1表示在已经组成金额i - coin的基础上再加一个当前硬币。
                    dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}

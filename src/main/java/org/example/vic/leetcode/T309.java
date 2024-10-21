package org.example.vic.leetcode;

/**
 * T309
 *
 * @author vic
 * @since 2024-10-21
 */
public class T309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[][] dp = new int[n][4];
        // 不持股，非卖出
        dp[0][0] = 0;
        // 卖出
        dp[0][1] = 0;
        // 冷冻
        dp[0][2] = 0;
        // 持股（买入）
        dp[0][3] = -prices[0];

        for(int i = 1; i < n; i++){
            // i日为不持股非卖出，则肯定是由i-1天不持股非卖出或冷冻转移而来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // i日为卖出，则肯定是由i-1天持股且在i日卖出
            dp[i][1] = dp[i - 1][3] + prices[i];
            // i日为冷冻，则肯定是由i-1天卖出状态转移而来
            dp[i][2] = dp[i - 1][1];
            // i日为持股，则i-1天持股或（冷冻 || 不持股非卖出）且在i日买入持股
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][0] - prices[i]);
            dp[i][3] = Math.max(dp[i][3], dp[i-1][2] - prices[i]);
        }

        // 最后结果是不持股的三种状态的最大值
        int result = Math.max(dp[n - 1][0], dp[n - 1][1]);
        result = Math.max(result, dp[n - 1][2]);

        return result;
    }

    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n == 0) {
    //         return 0;
    //     }
    //     /*
    //      * buy[i]：买入，表示第i天买入股票后，能获得的最大现金。
    //      * sell[i]：卖出，表示第i天卖出股票，能获得的最大现金
    //      * s1[i]：第一次持有股票，表示前一个状态buy[i-1]和s1[i-1]中较大者：即第i天结束时，持有股票但没卖出的最大现金
    //      * s2[i]：第二次持有股票，表示前一个状态s2[i-1]和sell[i-1]中较大者：即第i天结束时，已经完成一次交易的最大现金
    //      * buy->s1：买入股票并进入持有状态
    //      * s1->sell：卖出股票并获得收益
    //      * sell->s2：卖出股票后
    //      */
    //     int[] s1 = new int[n];
    //     int[] s2 = new int[n];
    //     int[] buy = new int[n];
    //     int[] sell = new int[n];
    //
    //     // 第一天初始状态
    //     s1[0] = buy[0] = -prices[0];
    //     sell[0] = s2[0] = 0;
    //     for (int i = 1; i < n; ++i) {
    //         buy[i] = s2[i - 1] - prices[i];
    //         s1[i] = Math.max(s1[i - 1], buy[i - 1]);
    //         sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
    //         s2[i] = Math.max(s2[i - 1], sell[i - 1]);
    //     }
    //     return Math.max(s2[n - 1], sell[n - 1]);
    // }
}

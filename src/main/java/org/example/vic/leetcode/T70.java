package org.example.vic.leetcode;

/**
 * T70 动态规划
 * 如果需求是最终状态，使用动态搜索比较方便；
 * 如果需求是输出所有路径，使用带有状态记录的优先搜索比较方便
 *
 * @author vic
 * @since 2024-10-10
 */
public class T70 {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

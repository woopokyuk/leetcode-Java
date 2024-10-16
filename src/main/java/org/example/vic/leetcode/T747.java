package org.example.vic.leetcode;

import java.util.Locale;

/**
 * T747
 *
 * @author vic
 * @since 2024-10-16
 */
public class T747 {
    /**
     * 一和零。返回最大子集长度，其中最多m个0，n个1
     *
     * @param strs 原字符串
     * @param m 最多m个0
     * @param n 最多n个1
     * @return 最大子集长度
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] counts = count(str);
            int count0 = counts[0];
            int count1 = counts[1];
            /*
             * 需要从大到小遍历:避免更新动态规划表时，重复使用同一字符串
             * 举个例子，假设我们有一个字符串"01"，并且m=2，n=2。
             * 如果我们从0开始递增地更新dp表，当处理到dp[1][1]时，我们会更新dp[1][1] = max(dp[1][1], 1 + dp[0][0])。
             * 然后当我们再次处理到dp[2][2]时，又会更新dp[2][2] = max(dp[2][2], 1 + dp[1][1])，
             * 这样就相当于使用了两次字符串"01"，这是不正确的。
             */
            for (int i = m; i >= count0; --i) {
                for (int j = n; j >= count1; --j) {
                    // dp[i][j]: 在i个0j个1的情况下，可组成的最长子集长度
                    // dp[i-count0][j-count1]：表示在选择当前字符串之前，已经有i-count0个0和j-count1个1的情况下能组成的最大字符串数量。
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-count0][j-count1]);
                }
            }
        }
        return dp[m][n];
    }

    // 需要统计子问题当前所计算的字符串的0，1个数，以确保不超过m,n
    private int[] count(String s) {
        int count0 = s.length();
        int count1 = 0;
        for (char c: s.toCharArray()) {
            if (c == '1') {
                ++count1;
                --count0;
            }
        }
        return new int[]{count0, count1};
    }
}

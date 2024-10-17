
package org.example.vic.leetcode;

/**
 * T650
 *
 * @author vic
 * @since 2024-10-17
 */
public class T650 {
    /**
     * 两个键的键盘：使用最少的操作次数，使记事本上恰好输出n个'A'
     *
     * @param n 期望个数
     * @return 达到期望个数时的最少操作次数
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            dp[i] = i;
            for (int j = 2; j * j <= i; ++j) {
                // j可以被i整除，说明长度i可以从长度j得到。
                // 此时长度j到长度i次数等于长度1到长度i/j次数，
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}

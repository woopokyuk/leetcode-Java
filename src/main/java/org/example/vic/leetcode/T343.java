
package org.example.vic.leetcode;


/**
 * T343
 *
 * @author vic
 * @since 2024-10-26
 */
public class T343 {
    /**
     * 整数拆分
     *
     * @param n 源数据
     * @return 拆分k个整数后，计算最大乘积
     */
    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        // dp[i]: 整数i拆分后的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 为什么两层循环
        // 外层：遍历所有可能的i
        // 内层：尝试讲1~i-1的所有整数j遍历一遍，讲i拆分成j和i-j，计算乘积
        for (int i = 2; i <= n; ++i) {
            // 为什么j从1开始，因为0是无效的，如果 j=0，那么 n=0+(n−0)=n，这并没有真正进行拆分
            for (int j = 1; j < i; ++j) {
                // 拆分j: j * dp[i-j]
                // 不拆分j: j * (i-j)
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}

package org.example.vic.leetcode;

import java.util.Arrays;

/**
 * T91
 *
 * @author vic
 * @since 2024-10-14
 */
public class T91 {
    /**
     * 解码总数
     *
     * @param s 待解码字符串
     * @return 次数
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        // dp[i]: 到第i个位置时，可解码的次数
        // dp[i] = 
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int prev = s.charAt(0) - '0';
        if (prev == 0) return 0;
        for (int i = 2; i <= n; ++i) {
            int cur = s.charAt(i-1) - '0';
            // 如果当前位置是0，那么前一位必须是1或2才能解码，否则无法解码
            if ((prev == 0 || prev > 2) && cur == 0) {
                return 0;
            }
            // 当前位置+前一位置可以组合解码
            if (prev == 1 || prev == 2 && cur < 7) {
                // 必须与前一位结合，如10: dp[0] = 1(初始值); dp[1] = 1; dp[2] = 1
                if (cur == 0) {
                    dp[i] = dp[i-2];
                } else {
                    // 既可以单独解码又可以组合解码，如11，dp[0] = 1; dp[1] = 1; dp[2] = 2;
                    dp[i] = dp[i-1] + dp[i-2];
                }
            } else {
                // 只能单独解码
                dp[i] = dp[i - 1];
            }
            prev = cur;
        }
        return dp[n];
    }
}

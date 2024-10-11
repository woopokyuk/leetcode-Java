package org.example.vic.leetcode;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @author vic
 * @since 2024-10-11
 */
public class T413 {
    /**
     * 连续等差子数组个数
     *
     * @param nums 原数组
     * @return 个数
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 2; i < n; ++i) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}

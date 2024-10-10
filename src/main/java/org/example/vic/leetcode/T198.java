package org.example.vic.leetcode;

/**
 * T198
 *
 * @author vic
 * @since 2024-10-10
 */
public class T198 {
    /**
     * 最多抢多少
     *
     * @param nums 钱财数组
     * @return 钱财数量
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i] 表示第i个房子时，能抢到的最大数量财富
        // 不抢i: dp[i-1]
        // 抢i: nums[i-1] + dp[i-2]。因为不能连续两个都抢，
        // 为什么是nums[i-1]而不是nums[i]，因为nums索引和dp索引不是一个概念。
        // 假设我们有一个数组 nums = [2, 7, 9, 3, 1]，我们来逐步计算 dp 数组：
        // 
        // 初始化：
        // dp[0] = 0：没有房屋时，抢劫金额为0。
        // dp[1] = nums[0] = 2：只有一个房屋时，抢劫金额就是该房屋的金额。
        // 计算 dp[2]：
        // 不抢劫第2个房屋：dp[1] = 2
        // 抢劫第2个房屋：nums[1] + dp[0] = 7 + 0 = 7
        // dp[2] = Math.max(2, 7) = 7
        // 计算 dp[3]：
        // 不抢劫第3个房屋：dp[2] = 7
        // 抢劫第3个房屋：nums[2] + dp[1] = 9 + 2 = 11
        // dp[3] = Math.max(7, 11) = 11
        // 计算 dp[4]：
        // 不抢劫第4个房屋：dp[3] = 11
        // 抢劫第4个房屋：nums[3] + dp[2] = 3 + 7 = 10
        // dp[4] = Math.max(11, 10) = 11
        // 计算 dp[5]：
        // 不抢劫第5个房屋：dp[4] = 11
        // 抢劫第5个房屋：nums[4] + dp[3] = 1 + 11 = 12
        // dp[5] = Math.max(11, 12) = 12
        int[] dp = new int[n + 1];
        // dp[0] 没房
        // 抢了第1个房
        dp[1] = nums[0];
        
        for (int i = 2; i <= n; ++i) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[n];
    }
}

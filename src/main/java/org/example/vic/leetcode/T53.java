package org.example.vic.leetcode;

/**
 * T53
 *
 * @author vic
 * @since 2024-10-21
 */
public class T53 {
    /**
     * 最大子数组和
     * -2,1,-3,4,-1,2,1,-5,4返回6
     *
     * @param nums 数组
     * @return 结果
     */
    // public int maxSubArray(int[] nums) {
    //     int pre = 0;
    //     int max = nums[0];
    //     for (int num : nums) {
    //         pre = Math.max(pre + num, num);
    //         max = Math.max(max, pre);
    //     }
    //     return max;
    // }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] 表示以第 i 个元素结尾的最大子数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 初始化第一个元素的最大子数组和为其自身值
        int max = dp[0]; // 记录全局的最大子数组和

        for (int i = 1; i < nums.length; i++) {
            // 对于每个元素，选择加上前一个元素结尾的最大子数组和，或者只取当前元素本身，
            // 这取决于哪一个更大，因为我们要找的是最大子数组和。
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 更新全局最大子数组和
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

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
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }
}

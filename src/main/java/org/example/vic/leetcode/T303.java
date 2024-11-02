package org.example.vic.leetcode;

public class T303 {

}


class NumArray {

    private int[] partial;

    public NumArray(int[] nums) {
        int n = nums.length;
        partial = new int[n+1];
        for (int i = 0; i < n; ++i) {
            partial[i+1] = partial[i] + nums[i];
        }
    }

    /**
     * 范围内的和
     *
     * @param left 左边界
     * @param right 右边界
     * @return 结果
     */
    public int sumRange(int left, int right) {
        return partial[right+1] - partial[left];
    }
}

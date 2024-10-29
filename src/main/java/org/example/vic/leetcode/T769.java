package org.example.vic.leetcode;

/**
 * T769
 *
 * @author vic
 * @since 2024-10-29
 */
public class T769 {
    /**
     * 最多能完成排序的块
     * [1,0,2,3,4] 分割成 [1, 0], [2], [3], [4]
     * 结果是4
     *
     * @param arr 含有0到n整数的数组，每个整数只出现一次
     * @return 分割成多少个子数组，使子数组增序排序后，原数组也是增序
     */
    public int maxChunksToSorted(int[] arr) {
        // 如果当前最大值大于数组位置，说明右边一定有更小的，无法分割，放进待排
        // 只包含0到n不重复数字，所以当前最大值一定不会小于数组位置
        // 结论：当前最大值数组位置时，做一次分割
        int res = 0;
        int max = 0;
        for (int i= 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ++res;
            }
        }
        return res;
    }
}

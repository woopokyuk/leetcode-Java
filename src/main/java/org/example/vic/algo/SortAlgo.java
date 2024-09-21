package org.example.vic.algo;

import java.util.ArrayList;

/**
 * SortAlgo
 *
 * @author vic
 * @since 2024-09-21
 */
public class SortAlgo {
    /**
     * 快速排序
     *
     * @param nums 待排序数组
     * @param l 起始位置
     * @param r 终止位置
     */
    public void quickSort(ArrayList<Integer> nums, int l, int r) {
        // 当区间的左边界l加上1大于等于右边界r时（即区间内元素个数小于等于1），则直接返回。
        // 这是因为一个或零个元素的序列已经是有序的。
        if (l + 1 >= r) {
            return;
        }

        // 初始化分区操作的左右指针。
        int first = l; // 左指针开始于区间的最左侧位置。
        int last = r - 1; // 右指针开始于区间的最右侧位置。
        int key = nums.get(first); // 选择左端点作为分区基准值（pivot）。

        // 当左右指针没有相遇时继续执行循环。
        while (first < last) {
            // 移动右指针向左寻找比基准值小的元素。
            while (first < last && nums.get(last) >= key) {
                --last;
            }
            // 将找到的小于基准值的元素放到左指针的位置。
            nums.set(first, nums.get(last));

            // 移动左指针向右寻找比基准值大的元素。
            while (first < last && nums.get(first) <= key) {
                ++first;
            }
            // 将找到的大于基准值的元素放到右指针的位置。
            nums.set(last, nums.get(first));
        }

        // 当左右指针相遇时，将基准值放置在最终位置。
        nums.set(first, key);

        // 对基准值左边的子数组进行递归排序。
        quickSort(nums, l, first);

        // 对基准值右边的子数组进行递归排序。
        quickSort(nums, first + 1, r);
    }
}

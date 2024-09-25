package org.example.vic.leetcode;

import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * T215
 *
 * @author vic
 * @since 2024-09-25
 */
public class T215 {
    /**
     * 快速选择 一般用于求解 k-th Element 问题
     * 与快速排序相似，不过只需要找到第k大的即可，不需要对其左右再进行排序
     *
     * @param nums 原数组
     * @param k 第k大
     * @return 结果
     */
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int target = nums.length - k;

        List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (l < r) {
            // 使用随机化的基准值选择
            int pivotIndex = new Random().nextInt(r - l + 1) + l;
            swap(temp, l, pivotIndex); // 将随机选中的基准值移到数组起始位置

            int mid = quickSelect((ArrayList<Integer>) temp, l, r);
            if (mid == target) {
                return temp.get(mid);
            }
            // 当前划分中点<目标索引，继续在右边部分找
            if (mid < target) {
                l = mid + 1;
            } else {
                // 当前划分中点>目标索引，继续在左边找
                r = mid - 1;
            }
        }
        return temp.get(l);
    }

    // 辅助函数：讲小于基准的放左侧，大于基准的放右侧，最终返回基准值
    private int quickSelect(ArrayList<Integer> nums, int l, int r) {
        int i = l + 1;
        int j = r;
        while (true) {
            // 从左边找，找到比基准值大的那个
            while (i < r && nums.get(i) <= nums.get(l)) {
                ++i;
            }
            // 从右边找，找打比基准值小的那个
            while (l < j && nums.get(j) >= nums.get(l)) {
                --j;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}

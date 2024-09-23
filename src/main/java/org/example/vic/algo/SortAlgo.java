package org.example.vic.algo;

import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.Arrays;

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

    /**
     * 归并排序（分治策略）
     *
     * @param nums 待排序数组
     * @param l 起始位置
     * @param r 终止位置
     * @param temp 辅助数组
     */
    public void mergeSort(ArrayList<Integer> nums, int l, int r, ArrayList<Integer> temp) {
        // 范围内只有0或1个元素了，无需再排
        if (l + 1 >= r) {
            return;
        }

        // 递归地将数组分成两半
        int m = l + (r - l) / 2;
        // 左边排序
        mergeSort(nums, l, m, temp);
        // 右边排序
        mergeSort(nums, m, r, temp);

        // 左子数组开始位置
        int p = l;
        // 右子数组开始位置
        int q = m;
        // 临时数组当前位置
        int i = l;
        // 合并两个已排序的部分数组到临时数组中
        while (p < m || q < r) {
            // 右边已经遍历完、或者左边元素<=右边元素，则拷贝左边元素到临时数组
            if (q >= r || (p < m && nums.get(p) <= nums.get(q))) {
                temp.set(i++, nums.get(p++));
            } else {
                // 拷贝右边到临时数组
                temp.set(i++, nums.get(q++));
            }
        }

        // 排好序的结果，从临时数组拷回原数组
        for (i = l; i < r; ++i) {
            nums.set(i, temp.get(i));
        }
    }

    /**
     * 插入排序
     *
     * @param nums 待排序数组
     * @param n 数组长度
     */
    public void insertSort(ArrayList<Integer> nums, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = i; j > 0 && nums.get(j) < nums.get(j-1); --j) {
                swap(nums, j, j-1);
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param nums 待排序数组
     * @param n 数组长度
     */
    public void bubbleSort(ArrayList<Integer> nums, int n) {
        // 是否交换过了
        boolean swapped = false;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n - i + 1; ++j) {
                if (nums.get(j) < nums.get(j - 1)) {
                    swap(nums, j, j - 1);
                    swapped = true;
                }
            }
            // 如果整个遍历过程未发生交换，说明已是有序的了。提前结束
            if (!swapped) {
                break;
            }
        }
    }
}

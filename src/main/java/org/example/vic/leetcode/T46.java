package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * T46 全排列：对于每一个当前位置i，我们可以将其于之后的任意位置交换，然后继续处理位置i+1，直到处理到最后一位
 * 回溯：只对原数组修改，在递归完成后再修改回来。避免每次遍历时都创建一个子数组存储位置i之前已经交换过的数组。
 *
 * @author vic
 * @since 2024-09-29
 */
public class T46 {
    /**
     * 全排列
     *
     * @param nums 原始数组
     * @return 结果
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, 0, ans);
        return ans;
    }

    // 辅助函数, level 是当前元素位置
    private void backtracking(int[] nums, int level, List<List<Integer>> ans) {
        if (level == nums.length - 1) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            swap(nums, i, level);
            backtracking(nums, level + 1, ans);
            swap(nums, i, level);
        }
    }

    // 交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

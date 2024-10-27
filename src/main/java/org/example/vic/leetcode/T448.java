package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class T448 {
    /**
     * 找到所有数组中消失的数字
     *
     * @param nums 数组
     * @return 消失的数字列表
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int pos = Math.abs(num) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        int n = nums.length;
//        Set<Integer> target = new HashSet<>();
//        for (int i = 1; i <= n; ++i) {
//            target.add(i);
//        }
//
//        for (int num : nums) {
//            target.remove(num);
//        }
//
//        return target.stream().toList();
//    }
}

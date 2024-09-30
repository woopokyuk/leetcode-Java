package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * T77
 *
 * @author vic
 * @since 2024-09-30
 */
public class T77 {
    /**
     * 组合
     *
     * @param n 1,n的范围
     * @param k 选择k个数字
     * @return 组合数组
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        // 保存当前的组合
        int[] comb = new int[k];
        int count = 0;
        backtracking(ans, comb, count, 1, n, k);
        return ans;
    }

    // 辅助函数
    private void backtracking(List<List<Integer>> ans, int[] comb, int count, int pos, int n, int k) {
        // 组合长度为k，添加到结果中
        if (count == k) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < k; ++i) {
                tmp.add(comb[i]);
            }
            ans.add(tmp);
            return;
        }

        for (int i = pos; i <= n; ++i) {
            comb[count] = i;
            backtracking(ans, comb, count+1, i+1, n, k);
        }
    }
}

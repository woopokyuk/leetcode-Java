package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * T417
 *
 * @author vic
 * @since 2024-09-29
 */
public class T417 {
    private static final int[] direction = new int[]{-1, 0, 1, 0, -1};

    /**
     * 太平洋大西洋水流问题
     * 哪些位置向下流水能到达两大洋: 问题抽象 -> 两大洋向上流都能达到的位置
     *
     * @param heights 高度数组
     * @return 坐标数组
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            new ArrayList<>();
        }

        int m = heights.length;
        int n = heights[0].length;
        // 记录达到太平洋
        boolean[][] canReachP = new boolean[m][n];
        // 记录到达大西洋
        boolean[][] canReachA = new boolean[m][n];

        // 遍历行，从第一列和最后一列开始探索
        for (int i = 0; i < m; ++i) {
            dfs(heights, canReachP, i, 0);
            dfs(heights, canReachA, i, n - 1);
        }

        // 遍历列，从第一行和最后一行开始探索
        for (int i = 0; i < n; ++i) {
            dfs(heights, canReachP, 0, i);
            dfs(heights, canReachA, m - 1, i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        // 检查标志位，记录哪些能到达
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return ans;
    }

    // 辅助函数
    private void dfs(int[][] heights, boolean[][] canReach, int r, int c) {
        // 已经到达过
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;

        // 新的行列坐标
        int x,y;
        // 遍历四个方向
        for (int i = 0; i < 4; ++i) {
            x = r + direction[i];
            y = c + direction[i + 1];

            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && heights[r][c] <= heights[x][y]) {
                dfs(heights, canReach, x, y);
            }
        }
    }
}

package org.example.vic.leetcode;

/**
 * T695
 * 深度优先搜索
 *
 * @author vic
 * @since 2024-09-26
 */
public class T695 {
    // 方向数组，用于表示四个方向（上、右、下、左）
    // direction数组包含两个维度信息：行和列。
    // 第一个元素 -1 和第二个元素 0 一起表示向上移动（行减一，列不变）；
    // 第二个元素 0 和第三个元素 1 一起表示向右移动（行不变，列加一）；
    // 第三个元素 1 和第四个元素 0 一起表示向下移动（行加一，列不变）；
    // 第四个元素 0 和第五个元素 -1 一起表示向左移动（行不变，列减一）。
    // {-1, 0, 1, 0}; // 行方向变化
    // {0, 1, 0, -1}; // 列方向变化
    private static final int[] direction = {-1, 0, 1, 0, -1};

    /**
     * 主函数。最大岛屿面积
     *
     * @param grid 原始数组
     * @return 最大面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        // 空，返回0
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // 如果是陆地，则从此处开始进行深度优先搜索
                if (grid[i][j] == 1) {
                    // 更新最大面积
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    // 辅助函数
    private int dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0; // 标记为已访问
        int area = 1;
        // 对当前位置的4个方向，递归进行深度优先搜索
        for (int i = 0; i < 4; ++i) {
            int x = r + direction[i]; // 新行
            int y = c + direction[i + 1]; // 新列
            // 新位置是陆地的，继续探索（当前需要满足在grid边界内）
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }
}

package org.example.vic.leetcode;

/**
 * T547 深度优先，与岛屿最大面积是同类问题
 *
 * @author vic
 * @since 2024-09-27
 */
public class T547 {
    /**
     * 省份数量
     *
     * @param isConnected 原始数组
     * @return 数量
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                ++cnt;
            }
        }
        return cnt;
    }

    // 辅助函数
    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        visited[i] = true;
        for (int k = 0; k < isConnected.length; ++k) {
            if (isConnected[i][k] == 1 && !visited[k]) {
                dfs(isConnected, k, visited);
            }
        }
    }
}

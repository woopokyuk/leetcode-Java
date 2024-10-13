package org.example.vic.leetcode;

import java.util.Arrays;

public class T542 {
    /**
     * 01矩阵 动态规划
     *
     * @param mat 原矩阵
     * @return 结果矩阵
     */
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return new int[0][0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            // 避免溢出
            Arrays.fill(dp[i], Integer.MAX_VALUE-1);
        }

        // 左上 -》 右下
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                    }
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                    }
                }
            }
        }

        // 右下 -》 左上
        for (int i = m-1; i >= 0; --i) {
            for (int j = n-1; j >= 0; --j) {
                if (mat[i][j] != 0) {
                    if (j < n-1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    }
                    if (i < m-1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                    }
                }
            }
        }

        return dp;
    }
}

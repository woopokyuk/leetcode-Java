
package org.example.vic.leetcode;

/**
 * T72
 *
 * @author vic
 * @since 2024-10-17
 */
public class T72 {
    /**
     * 编辑距离：将单词一转成单词二使用的最少操作数
     * dp[i][j] 表示单词一第i位置为止，转变成单词二第j位置为止。需要几步操作
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 距离
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
}

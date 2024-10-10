
package org.example.vic.leetcode;

/**
 * T79
 *
 * @author vic
 * @since 2024-10-10
 */
public class T79 {
    /**
     * 主函数，检查给定的单词是否存在于字符矩阵中。
     *
     * @param board 字符矩阵
     * @param word 需要查找的单词
     * @return 如果单词存在于矩阵中则返回 true，否则返回 false
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        // 访问标记
        boolean[][] visited = new boolean[m][n];
        boolean find = false;

        // 以每个元素为起点，回溯搜索
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 找到了就即刻退出
                if (backtracking(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return find;
    }

    // 辅助函数，若找到目标单词，返回true；否则，返回false
    private boolean backtracking(int i, int j, char[][] board, String word, int pos, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        // 已访问过或者目标字符不匹配
        if (visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }

        // 匹配到了最后一个字符，说明命中了
        if (pos == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        // 四个方向递归
        if (backtracking(i - 1, j, board, word, pos + 1, visited)
                || backtracking(i + 1, j, board, word, pos + 1, visited)
                || backtracking(i, j - 1, board, word, pos + 1, visited)
                || backtracking(i, j + 1, board, word, pos + 1, visited)) {
            return true;
        }
        // 恢复未访问状态
        visited[i][j] = false;

        return false;
    }
}

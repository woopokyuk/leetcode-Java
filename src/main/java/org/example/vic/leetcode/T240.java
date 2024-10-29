package org.example.vic.leetcode;

/**
 * T240
 *
 * @author vic
 * @since 2024-10-29
 */
public class T240 {
    /**
     * 搜索二维矩阵
     *
     * @param matrix 原始矩阵，每行每列都是增序
     * @param target 5是否在矩阵中
     * @return 结果
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        // 从右上角查找，如果当前值大于搜索值，左移；否则下移；左下角找不到，说明不存在
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }

    // public boolean searchMatrix(int[][] matrix, int target) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int[] arr : matrix) {
    //         for (int num : arr) {
    //             set.add(num);
    //         }
    //     }
    //     return set.contains(target);
    // }
}

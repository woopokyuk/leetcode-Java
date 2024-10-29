package org.example.vic.leetcode;

/**
 * T48
 *
 * @author vic
 * @since 2024-10-29
 */
public class T48 {
    /**
     * 旋转图像 要求只能在原矩阵修改，尽量不创建额外的储存空间
     * 以4*4矩阵为例
     * i=0, j=0时
     * temp = m[0][3]
     * m[0][3] = m[0][0]
     * m[0][0] = m[3][0]
     * m[3][0] = m[3][3]
     * m[3][3] = temp
     * //
     * i=0, j=1时
     * temp = m[1][3]
     * m[1][3] = m[0][1]
     * m[0][1] = m[2][0]
     * m[2][0] = m[2][2]
     * m[2][2] = temp
     *
     * @param matrix 原始矩阵
     */
    public void rotate(int[][] matrix) {
        // 每次只考虑四个间隔90度的位置，可以进行O(1)额外空间的旋转
        int temp = 0;
        int n = matrix.length - 1;
        // 只需要遍历一半长度，就可以走到最中心的4方块
        for (int i = 0; i <= n/2; ++i) {
            for (int j = i; j < n - i; ++j) {
                // 先将右上，存起来
                temp = matrix[j][n-i];
                // 左上赋给右上
                matrix[j][n-i] = matrix[i][j];
                // 左下赋给左上
                matrix[i][j] = matrix[n-j][i];
                // 右下赋给左下
                matrix[n-j][i] = matrix[n-i][n-j];
                // 右上（临时）赋给右下
                matrix[n-i][n-j] = temp;
            }
        }
    }
}

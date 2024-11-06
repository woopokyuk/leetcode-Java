package org.example.vic.leetcode;

/**
 * T696
 *
 * @author vic
 * @since 2024-11-06
 */
public class T696 {
    /**
     * 计算二进制字串
     * a 记录当前位置数字相同且连续的长度
     * b 记录当前数字之前连续的不同数字长度
     * b >= a, 说明满足
     *
     * @param s 原字符串
     * @return 个数
     */
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int count = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ++cur;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ++count;
            }
        }
        return count;
    }
}

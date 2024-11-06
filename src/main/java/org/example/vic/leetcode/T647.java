package org.example.vic.leetcode;

/**
 * T647
 *
 * @author vic
 * @since 2024-11-06
 */
public class T647 {
    /**
     * 回文字串
     * 从每个位置向左右延申
     *
     * @param s 字符串
     * @return 个数
     */
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += extendSubStrings(s, i, i);
            cnt += extendSubStrings(s, i, i+1);
        }
        return cnt;
    }

    private int extendSubStrings(String s, int l, int r) {
        int cnt = 0;
        while (l >= 0 && r < s.length() & s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
            ++cnt;
        }
        return cnt;
    }
}

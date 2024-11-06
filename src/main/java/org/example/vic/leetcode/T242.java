package org.example.vic.leetcode;

/**
 * T242
 *
 * @author vic
 * @since 2024-11-06
 */
public class T242 {
    /**
     * 是否异位
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 结果
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[t.charAt(i) - 'a'];
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}

package org.example.vic.leetcode;

/**
 * T205
 *
 * @author vic
 * @since 2024-11-06
 */
public class T205 {
    /**
     * 第一次出现的位置一样说明同构，否则不是
     *
     * @param s 字符串s
     * @param t 字符串t
     * @return 结果
     */
    public boolean isIsomorphic(String s, String t) {
        int[] sFirst = new int[129];
        int[] tFirst = new int[129];
        for (int i = 0; i < s.length(); ++i) {
            if (sFirst[s.charAt(i)] != tFirst[t.charAt(i)]) {
                return false;
            }
            // 不能给0，否则可能有错误情况，如aa ab，a首次先给0，到b时，因为b没给，默认0。导致认为同构
            sFirst[s.charAt(i)] = i+1;
            tFirst[t.charAt(i)] = i+1;
        }
        return true;
    }    
}

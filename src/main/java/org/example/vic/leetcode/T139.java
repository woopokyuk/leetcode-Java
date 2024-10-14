package org.example.vic.leetcode;

import java.util.List;

/**
 * T139 动态规划
 *
 * @author vic
 * @since 2024-10-14
 */
public class T139 {
    /**
     * 单词拆分
     *
     * @param s 单词
     * @param wordDict 字典
     * @return 字典提供的元素是否能拼出单词
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        // 空字符串总可以拆分
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (String word : wordDict) {
                int len = word.length();
                // 子字符串是否等于当前单词
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    // dp[i]: s的前i的字符是否可以被拆分成字典中的一个或多个单词
                    // dp[i-len] 表示 0到i-len-1的字串能拼出来。i-len到i的字串等于当前单词，所以dp[i]也能拼出来
                    // 为什么是 dp[i] || dp[i-len] 而不是dp[i-len]：确保dp[i]被设置true后不会因为后面匹配的无效路径刷掉
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[n];
    }
}

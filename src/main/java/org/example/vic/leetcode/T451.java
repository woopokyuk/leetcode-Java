package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * T451
 *
 * @author vic
 * @since 2024-09-25
 */
public class T451 {
    /**
     * 根据字符出现次数排序
     * 比如tree，返回eetr或eert均可
     *
     * @param s 原始字符串
     * @return 排序后字符串
     */
    public String frequencySort(String s) {
        // 统计字符出现次数
        Map<Character, Integer> count = new HashMap<>();
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            int currentCount = count.getOrDefault(c, 0) + 1;
            count.put(c, currentCount);
            maxCount = Math.max(maxCount, currentCount);
        }

        // 创建桶
        List<List<Character>> buckets = new ArrayList<>(maxCount + 1);
        for (int i = 0; i <= maxCount; ++i) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // 收集结果
        StringBuilder result = new StringBuilder();
        for (int i = maxCount; i >= 0; --i) {
            List<Character> bucket = buckets.get(i);
            for (Character c : bucket) {
                char[] tmp = new char[i];
                Arrays.fill(tmp, c);
                result.append(String.valueOf(tmp));
            }
        }
        
        return result.toString();
    }
}

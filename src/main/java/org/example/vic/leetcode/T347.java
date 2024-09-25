package org.example.vic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * T347
 *
 * @author vic
 * @since 2024-09-25
 */
public class T347 {
    /**
     * 桶排序
     * 为每个值设立一个桶，桶内记录这个值出现的次数（或其他属性），然后对桶排序
     *
     * @param nums 原数组
     * @param k 前k个高频元素
     * @return 结果数组
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 计算每个元素的出现次数
        Map<Integer, Integer> counts = new HashMap<>();
        // maxCount是最高频元素出现的次数
        // 为什么记录maxCount：遍历时可以从最高频率的桶开始往下找
        int maxCount = 0;
        for (int num : nums) {
            int currentCount = counts.getOrDefault(num, 0) + 1;
            counts.put(num, currentCount);
            maxCount = Math.max(maxCount, currentCount);
        }

        // 根据出现次数创建桶，创建结果是 {次数，值}的一个二维数组
        List<List<Integer>> buckets = new ArrayList<>(maxCount + 1);
        for (int i = 0; i <= maxCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        // 收集结果
        List<Integer> result = new ArrayList<>();
        for (int i = maxCount; i >= 0 && result.size() < k; i--) {
            List<Integer> bucket = buckets.get(i);
            // 频率可能存在相等的情况，所以bucket大小可能大于1
            for (int num : bucket) {
                result.add(num);
                if (result.size() == k) {
                    break;
                }
            }
            if (result.size() == k) {
                break;
            }
        }
        // List转int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
}

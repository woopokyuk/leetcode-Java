package org.example.vic.leetcode;

import java.util.Stack;

/**
 * T739
 *
 * @author vic
 * @since 2024-11-01
 */
public class T739 {
    /**
     * 每日温度
     * 73,74,75,71,69,72,76,73
     *
     * @param temperatures 温度数组
     * @return 下一更高温度几天后出现
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        // 记录位置（日期），而非温度
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.empty()) {
                int pre = stack.peek();
                if (temperatures[i] <= temperatures[pre]) {
                    break;
                }
                // 当前温度比栈顶的温度更高。取出栈顶，记录pre要等待i-pre天
                stack.pop();
                res[pre] = i - pre;
            }
            // 栈空，说明符合要求，压入当前位置
            stack.push(i);
        }
        return res;
    }
}

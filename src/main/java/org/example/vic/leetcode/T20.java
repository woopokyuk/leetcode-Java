
package org.example.vic.leetcode;

import java.util.Stack;

/**
 * T20
 *
 * @author vic
 * @since 2024-11-01
 */
public class T20 {
    /**
     * 有效的括号
     *
     * @param s 括号串
     * @return 是否有效
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                char peek = stack.peek();
                if ((peek == '{' && s.charAt(i) == '}') || (peek == '[' && s.charAt(i) == ']')
                        || (peek == '(' && s.charAt(i) == ')')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

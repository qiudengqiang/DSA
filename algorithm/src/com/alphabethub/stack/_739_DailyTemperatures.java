package com.alphabethub.stack;

import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        int[] daily = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length; i > 0; i--) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                daily[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return daily;
    }
}

package com.alphabethub.stack;

import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class _739_DailyTemperatures {

    /**
     * 思路：在栈pop的时候计算右边的值
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures_pop(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;

        Stack<Integer> stack = new Stack<>();
        //存放元素索引，而不是元素
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}

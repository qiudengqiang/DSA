package me.techbird.leetcode.stack;

import me.techbird.leetcode.api.stack.Stack;

/**
 * 227.基本计算器-ii（中缀表达式求解）
 * https://leetcode-cn.com/problems/basic-calculator-ii
 */
public class _227_BaseCalculator2 {


    public static void main(String[] args) {
        String s = "3+2*2";
        String s2 = " 3+5 / 2 ";
        String s3 = "42";
        String s4 = "1-1+1";
        String s5 = "1-12+3";
        String s6 = "(1+(4+5+2)-3)+(6+8)";
        String s7 = "2*(5+5*2)/3+(6/2+8)";
        String s8 = " 2-1 + 2 ";
        System.out.println(calculate(s8));
    }

    //为解决括号
    static int pos = 0;

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (; pos < s.length(); pos++) {
            char c = s.charAt(pos);
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c))
                num = 10 * num + (c - '0');

            // 遇到'(' 开始递归
            if(c == '(') {
                pos++;
                num = calculate(s);
            }

            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if ((!Character.isDigit(c) && c != ' ') || pos == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        Integer pre =stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        Integer top = stack.pop();
                        stack.push(top / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
            // 遇到')' 结束递归
            if(c == ')') break;
        }
        // 将栈中所有结果求和就是答案
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
}

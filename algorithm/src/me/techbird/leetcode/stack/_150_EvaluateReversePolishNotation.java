package me.techbird.leetcode.stack;

import java.util.Stack;

/**
 * 150.逆波兰表达式求值（后缀表达式）
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] s = {"2", "1", "+", "3", "*"};
        String[] s2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] s3 = {"4", "13", "5", "/", "+"};
        String[] s4 = {"2", "+"};
        System.out.println(evalRPN2(s3));
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            Integer first, second;
            switch (token) {
                case "+":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(first + second);
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(first * second);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push((int) Math.floor(second / first));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }



    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                Integer num = stack.pop();
                stack.push((int) Math.floor(stack.pop() / num));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

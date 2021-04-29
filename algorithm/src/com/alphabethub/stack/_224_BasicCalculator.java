package com.alphabethub.stack;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 224.基本计算器
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class _224_BasicCalculator {

    public static void main(String[] args) {
        String s = "3+2*2";
        String s2 = " 3+5 / 2 ";
        String s3 = "42";
        String s4 = "1-1+1";
        System.out.println(calculate(s4));
    }

    /**
     * 中缀表达式转后缀表达式，然后对后缀表达式求值
     * 中缀转后缀：
     * - 数字直接输出到后缀表达式
     * - 栈为空时，遇到运算符，直接入栈
     * - 遇到运算符，弹出所有优先级大于或等于该运算符的栈顶元素，并将该运算符入栈
     * - 将栈中元素依次出栈
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        //中缀转后缀
        LinkedList<String> list = new LinkedList<>();
        Stack<String> charStack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                while (!charStack.isEmpty() && !isNumeric(charStack.lastElement())) {
                    list.add(charStack.pop());
                }
                charStack.push(String.valueOf(c));
            }

            if (c == '*' || c == '/') {
                while (!charStack.isEmpty() && (charStack.lastElement().equals("/") || charStack.lastElement().equals("*"))) {
                    list.add(charStack.pop());
                }
                charStack.push(String.valueOf(c));
            }

            if(Character.isDigit(c)) {//数字
                // 注意多位数的获取
                int k = i + 1;
                for (; k < s.length() && Character.isDigit(s.charAt(k)); k++) {
                }
                list.add(s.substring(i, k));
                i = k - 1;// 更新 i
            }
        }

        while (charStack.size() > 0) {
            list.add(charStack.pop());
        }


        //后缀表达式求值
        return evalRPN(list);
    }

    /**
     * 根据所给后缀表达式求值
     * 计算后缀：
     * - 遇到数字，入栈
     * - 遇到运算符，弹出栈顶两个元素，做运算，并将结果入栈
     * - 重复上述步骤，直到表达式最右端
     *
     * @param list
     * @return
     */
    public static int evalRPN(LinkedList<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String token : list) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer val = stack.pop();
                    stack.push((int) Math.floor(stack.pop() / val));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}

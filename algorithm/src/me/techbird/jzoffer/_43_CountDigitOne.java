package me.techbird.jzoffer;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 */
public class _43_CountDigitOne {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1999));
    }

    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次
     *
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String string = String.valueOf(i);
            if (string.contains("1")) {
                char[] array = string.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == '1') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //O(nlogn)
    public static int count(int n){
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += numberOf1(i);
        }
        return num;
    }

    private static int numberOf1(int i) {
        int number=0;
        while(i != 0){
            if(i%10 == 1) number++;
            i = i/10;
        }
        return 0;
    }


    //利用递归O(logn)
    public static int f(int n) {
        if (n <= 0) return 0;
        String string = String.valueOf(n);
        int high = string.charAt(0) - '0';
        int pow = (int) Math.pow(10, string.length() - 1);
        int last = n - high * pow;
        System.out.println(high + "-" + pow + "-" + last);
        if (high == 1) {
            return f(pow - 1) + last + 1 + f(last);
        } else {
            return pow + high * f(pow - 1) + f(last);
        }
    }
}

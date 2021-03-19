package me.techbird.recursion;

/**
 * 汉诺塔，A、B、C柱子堆盘子问题。思路
 */
public class Hanota {

    public static void main(String[] args) {
        new Hanota().hanota(3, "A", "B", "C");
    }

    public void hanota(int n, String original, String auxiliary, String target) {
        if (n <= 1) {
            move(n, original, target);
            return;
        }
        hanota(n - 1, original, target, auxiliary);
        move(n, original, target);
        hanota(n - 1, auxiliary, original, target);
    }

    public void move(Integer i, String from, String to) {
        System.out.println(i + "号盘子：" + from + "->" + to);
    }
}

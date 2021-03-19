package me.techbird.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 08.06. 汉诺塔问题TODO
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class _08_Hanota {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        new _08_Hanota().hanota(A, B, C);
        C.forEach((Integer i)->{
            System.out.println(i);
        });
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    public void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        if (num <= 1) {
            target.add(original.remove(original.size() - 1));
            return;
        }
        movePlate(num - 1, original, target, auxiliary);
        target.add(original.remove(original.size() - 1));
        movePlate(num - 1, auxiliary, original, target);
    }
}

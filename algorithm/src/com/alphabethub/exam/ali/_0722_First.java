package com.alphabethub.exam.ali;


import java.util.Scanner;

/**
 * 对于分数Xi / Yi ，我们给T组数据，n表示每组数据有n个分数，让这些分数相加看是否能等于一个整数，如果相加为整数返回Yes，否则返回No。
 * <p>
 * 用例数据：
 * 2
 * 3
 * 1 2
 * 1 3
 * 1 6
 * 4
 * 2 3
 * 4 6
 * 2 6
 * 3 8
 *
 * <p>
 * Yes
 * No
 */
public class _0722_First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int row = sc.nextInt();
            int[] sums = new int[2];
            for (int j = 0; j < row; j++) {
                int child = sc.nextInt();
                int parent = sc.nextInt();
                sums = sum(child, parent, sums[0], sums[1]);
            }
            String ret;
            if (sums[0] > sums[1]) {
                ret = sums[0] % sums[1] == 0 ? "Yes" : "No";
            } else if (sums[0] == sums[1]) {
                ret = sums[0] == sums[1] ? "Yes" : "No";
            } else {
                ret = "No";
            }
            System.out.println(ret);
        }
    }

    public static int[] sum(int child, int parent, int childSum, int parentSum) {
        if (parent != parentSum && parentSum != 0) {
            int ret = parentSum * parent;
            child = child * (ret / parent);
            childSum = childSum * (ret / parentSum);
            parentSum = ret;
        } else if (parent != parentSum) {
            parentSum += parent;
        }
        childSum += child;
        return new int[]{childSum, parentSum};
    }
}

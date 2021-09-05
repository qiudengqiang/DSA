package com.alphabethub.exam.xiaomi;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 给定一个从1到n的整数列表，从第一个数字开始计数，遇到3的倍数时，将该数从列表中删除，直至列表末尾。
 * <p>
 * 在剩下的数字中，从第一个数字开始，继续之前的计数值，同样遇到3的倍数时，删除该数。
 * <p>
 * 循环上面的步骤，直到列表中只剩下一个数字。
 * <p>
 * 根据指定的数字n，来判断最后剩下的数字是哪个。
 * <p>
 * 输入:n = 5
 * 过程：第一步： 1, 2, (3), 4, 5
 * 第二步： (1), 2, 4, (5)
 * 第三步：(2), 4
 * <p>
 * 样例输入：5
 * 样例输出：4
 */
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CopyOnWriteArrayList<Integer> coa = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= n; i++) {
            coa.add(i);
        }
        int i = 1;
        int j = 0;
        int len = n;
        while (coa.size() != 1) {
            if (i % 3 == 0) {
                if (i == 3) {
                    coa.remove(coa.get(i % len));
                } else {
                    coa.remove(coa.get((i - j) % len));
                }
                j = 0;
                len--;
            }
            j++;
            i++;
        }
        System.out.println(coa.get(0));
    }

}

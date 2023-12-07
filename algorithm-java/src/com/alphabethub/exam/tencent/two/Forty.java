package com.alphabethub.exam.tencent.two;

import java.util.Scanner;

public class Forty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        System.out.println(n);

    }

    public static int attackNum(int n) {
        if (n % 2 == 0) {//偶数
            int i = (int) Math.log(n);
        }
        return 0;
    }

}

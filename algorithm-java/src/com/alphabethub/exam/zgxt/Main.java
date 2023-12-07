package com.alphabethub.exam.zgxt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String hex = in.next();
            long sum = 0;
            int slen = hex.length();
            for (int i = 0; i < slen; i++) {
                char a = hex.charAt(i);
                if (a >= '0' && a <= '9') {
                    sum += (a - '0') * Math.pow(16, slen - i - 1);
                } else if (a >= 'A' && a <= 'F') {
                    sum += (a - 'A' + 10) * Math.pow(16, slen - i - 1);
                }
            }
            System.out.println(sum);
        }
    }

    public static int sum(int num) {
        if (num == 1) return 1;
        return num + sum(num - 1);
    }
}

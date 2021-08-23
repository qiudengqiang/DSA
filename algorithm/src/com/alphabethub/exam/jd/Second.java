package com.alphabethub.exam.jd;

import java.util.Random;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(new Random().nextInt(i) + " ");
            }
        }
    }

    public static int splitString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            return splitString(chars, i);
        }
        return 0;
    }

    public static int splitString(char[] s, int step) {
        String[] strs = new String[s.length / 2];
        for (int i = 0; i < s.length; i += step) {
            String str = "";
            for (int j = 0; j < step; j++) {
                str += s[i + j];
            }
            strs[i] = str;
        }
        int pairs = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i != j && strs[i].equals(strs[j])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}

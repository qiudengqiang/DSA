package com.alphabethub.exam.dxm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String heartFlows = sc.nextLine();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String dcFlows = sc.next();
            System.out.println(isValid(heartFlows, dcFlows));
        }
    }

    public static String isValid(String heartFlows, String dcFlows) {
        char[] heart = heartFlows.toCharArray();
        char[] dc = dcFlows.toCharArray();
        boolean result = true;
        for (int i = 0; i < heart.length; i++) {
            if (heart[i] == 'X' && dc[i] == '1') {
                result = false;
            }
        }
        return result ? "YES" : "NO";
    }
}

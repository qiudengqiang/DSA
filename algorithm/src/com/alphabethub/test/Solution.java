package com.alphabethub.test;

public class Solution {

    public static void main(String[] args) {
        String s1 = "12";
        String s2 = new String("12");
        String s3 = "1"+"2";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }

}

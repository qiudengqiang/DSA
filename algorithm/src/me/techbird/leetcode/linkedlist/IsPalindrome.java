package me.techbird.leetcode.linkedlist;

import java.util.LinkedList;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalidrome(112));
    }

    public static boolean isPalidrome(int x){
        String string = String.valueOf(x);
        for (int i = 0; i < string.length(); i++) {
           if(string.charAt(i) != string.charAt(string.length()-i-1)){
              return false;
           }
        }
        return true;
    }
}

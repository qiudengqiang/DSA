package com.alphabethub.exam.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] students = s.split(" ");
        System.out.println(paper(students));
    }

    public static int paper(String[] ages) {
        int paperCount = 0;
        int[] papers = new int[ages.length];
        Arrays.fill(papers, 1);
        for (int i = 0; i < ages.length; i++) {
            if (i < 1 || i > ages.length - 2) continue;
            int age = Integer.valueOf(ages[i]);
            int ageLeft = Integer.valueOf(ages[i - 1]);
            int ageRight = Integer.valueOf(ages[i + 1]);
            int max = Math.max(ageLeft, ageRight);
            if (age > max && max == ageLeft) {
                papers[i] = papers[i - 1] + 1;
            } else if (age > max && max == ageRight) {
                papers[i] = papers[i + 1] + 1;
            }
        }
        if (ages.length > 1) {
            if (Integer.valueOf(ages[1]) > Integer.valueOf(ages[0])) {
                papers[0] = papers[1] + 1;
            }

            if (Integer.valueOf(ages[ages.length - 1]) > Integer.valueOf(ages[ages.length - 2])) {
                papers[ages.length - 1] = papers[ages.length - 2] + 1;
            }
        }

        for (int i = 0; i < papers.length; i++) {
            paperCount += papers[i];
        }
        return paperCount;
    }
}

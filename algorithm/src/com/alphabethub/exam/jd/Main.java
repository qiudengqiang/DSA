package com.alphabethub.exam.jd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j && Point.isLJ(points[i], points[j])) {
                    count++;
                }
            }
        }
        System.out.println(count/2);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static boolean isLJ(Point p1, Point p2) {
            return Math.abs(p1.y - p2.y) == Math.abs(p1.x - p2.x);
        }
    }
}

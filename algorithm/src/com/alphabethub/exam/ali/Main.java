package com.alphabethub.exam.ali;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point[] points = new Point[3];
        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);
            points[i] = point;
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                if (points[i].x > points[j].x && points[i].y > points[j].y) {
                    points[i].isRight = true;
                    points[i].isBottom = true;
                }else if (points[i].x > points[j].x && points[i].y < points[j].y) {
                    points[i].isRight = true;
                    points[i].isTop = true;
                }else if (points[i].x < points[j].x && points[i].y < points[j].y) {
                    points[i].isLeft = true;
                    points[i].isTop = true;
                }else if (points[i].x < points[j].x && points[i].y > points[j].y) {
                    points[i].isLeft = true;
                    points[i].isBottom = true;
                }
            }
        }
        Rect rect = new Rect();
        for (int i = 0; i < points.length; i++) {
            Point point = points[i];
            if (point.isLeft && point.isTop) {//leftTop
                rect.leftTop = point;
            }else if (point.isLeft && point.isBottom) {//leftBottom
                rect.leftBottom = point;
            }else if (point.isRight && point.isTop) {//rightTop
                rect.rightTop = point;
            }else if (point.isRight && point.isBottom) {//rightBottom
                rect.rightBottom = point;
            }
        }

        if (rect.leftTop == null) {
            System.out.println(rect.leftBottom.x + " " + rect.rightTop.y);
        }
        if (rect.leftBottom == null) {
            System.out.println(rect.leftTop.x + " " + rect.rightBottom.y);
        }
        if (rect.rightTop == null) {
            System.out.println(rect.rightBottom.x + " " + rect.leftTop.y);
        }
        if (rect.rightBottom == null) {
            System.out.println(rect.rightTop.x + " " + rect.leftBottom.y);
        }
    }


    static class Point {
        int x;
        int y;
        boolean isLeft = false;
        boolean isRight = false;
        boolean isTop = false;
        boolean isBottom = false;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Rect {
        Point leftTop;
        Point rightTop;
        Point leftBottom;
        Point rightBottom;

    }

}

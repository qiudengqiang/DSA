package com.alphabethub.backtracking;

/**
 * 利用位移技术，针对8皇后的优化算法，对空间做极致的压缩
 */
public class Queens3 {
    public static void main(String[] args) {

        new Queens3().placeQueens();
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] queens;
    /**
     * 标记着某一列是否有皇后
     */
    byte cols;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    short leftTop;
    /**
     * 标记着某一斜线上是否有皇后（左上角 -> 右下角）
     */
    short rightTop;

    /**
     * 记录有多少种摆法
     */
    int ways;

    private void placeQueens() {
        queens = new int[8];
        place(0);

        System.out.println("8 皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第 row 行开始摆放皇后
     *
     * @param row
     */
    private void place(int row) {
        if (row == 8) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < 8; col++) {
            //判断是否可以
            int cv = 1 << col;
            if ((cols & cv) != 0) continue;
            int lv = 1 << (row - col + 7);
            if ((leftTop & lv) != 0) continue;
            int rv = 1 << (row + col);
            if ((rightTop & rv) != 0) continue;

            //摆放皇后
            queens[row] = col;
            cols |= cv;
            leftTop |= lv;
            rightTop |= rv;

            //摆放下一行皇后
            place(row + 1);

            //回溯
            cols &= ~cv;
            leftTop &= ~lv;
            rightTop &= ~rv;
        }
    }

    void show() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}

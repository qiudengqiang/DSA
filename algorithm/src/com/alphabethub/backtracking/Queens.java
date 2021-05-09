package com.alphabethub.backtracking;

/**
 * N皇后问题
 */
public class Queens {
    public static void main(String[] args) {
        new Queens().placeQueens(8);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;
    /**
     * 有多少种摆放方式
     */
    int ways;

    /**
     * 摆放n皇后
     *
     * @param n
     */
    void placeQueens(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 摆放第row行的皇后
     *
     * @param row
     */
    private void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }


    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;
            if (row - i == Math.abs(col - cols[i])) return false;
        }
        return true;
    }

    private void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}

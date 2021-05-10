package com.alphabethub.backtracking;

public class _52_NQueends2 {

    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;
    int ways;

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        if(n<1) return 0;

        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];

        place(0);

        return ways;
    }

    void place(int row) {
        if (row == cols.length) {
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;


            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);

            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }
}

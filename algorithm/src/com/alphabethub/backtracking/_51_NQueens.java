package com.alphabethub.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    int[] queens;
    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;

    List<List<String>> list = new ArrayList<>();

    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;

        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];

        place(0);
        return list;
    }

    void place(int row) {
        if (row == queens.length) {
            show();
            return;
        }
        for (int col = 0; col < queens.length; col++) {
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);

            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show() {
        List<String> arr = new ArrayList<>();
        for (int row = 0; row < queens.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < queens.length; col++) {
                if (queens[row] == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            arr.add(sb.toString());
        }
        list.add(arr);
    }
}

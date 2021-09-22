package com.alphabethub.jzoffer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class _04_FindNumberIn2DArray {

    /**
     * 暴力破解：forfor嵌套循环，算法时间复杂度为O(n*m)
     * 优化思路：利用矩阵"从上到下递增、从左到右递增” 的特点，引入标志数。降低算法时间复杂度为O(n+m)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(n+m)
     * 空间复杂度：0(1)
     * @param matrix
     * @param target
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            int num = matrix[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

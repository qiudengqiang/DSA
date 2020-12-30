package me.techbird.leetcode.jzoffer;

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
}

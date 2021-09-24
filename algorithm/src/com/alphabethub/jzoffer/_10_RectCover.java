package com.alphabethub.jzoffer;

public class _10_RectCover {
    /**
     * 矩形覆盖有多少种形式
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <= 2) return target;
        int pre1 = 2;//n最后使用1块，剩下n-1块的写法
        int pre2 = 1;//n最后使用2块，剩下n-2块的写法
        for (int i = 3; i <= target; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}

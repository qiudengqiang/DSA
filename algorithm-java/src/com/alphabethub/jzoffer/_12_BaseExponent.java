package com.alphabethub.jzoffer;

public class _12_BaseExponent {
    public double power(double base, int exponent) {
        if (base == 0.0) return 0.0;
        //前置结果设置为1.0，即当exponent=0的时候，就是这个结果
        double result = 1.0d;
        //获取指数的绝对值
        int e = exponent > 0 ? exponent : -exponent;
        //根据指数大小循环累乘
        for (int i = 1; i <= e; i++) {
            result *= base;
        }
        //根据指数正负，返回结果
        return exponent > 0 ? result : 1 / result;
    }
}

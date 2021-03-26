package me.techbird.recursion;

/**
 * 尾递归的示例
 */
public class TailRecursion {

    public static void main(String[] args) {
        System.out.println(new TailRecursion().factorial(4));
        System.out.println(new TailRecursion().fib(40));
    }



    /**
     * fibnacci尾递归示例
     *
     * @param n
     */
    public int fib(int n) {
        return fib(n, 1, 1);
    }

    public int fib(int n, int first, int second) {
        if (n <= 1) return 1;
        return fib(n - 1, second, first + second);
    }

    /**
     * 阶乘的尾递归示例
     *
     * @param n
     * @return
     */
    public int factorial(int n) {
        return factorial(n, 1);
    }

    public int factorial(int n, int result) {
        if (n <= 1) return result;

        return factorial(n - 1, n * result);

    }
}

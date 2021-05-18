package com.alphabethub.api.bloomfilter;

public class BloomFilter<T> {
    /**
     * 二进制向量的长度（一共有多少个二进制位）
     */
    private int bitSize;
    /**
     * 装填二进制向量(eg:0101010101010101001011)
     */
    private long[] bits;
    /**
     * 哈希函数的个数
     */
    private int hashSize;

    /**
     * @param n 数据规模
     * @param p 误判率，取值范围(0, 1)
     */
    public BloomFilter(int n, double p) {
        if (n <= 0 || p <= 0 || p >= 1) {
            throw new IllegalArgumentException("wrong n or p");
        }

        double ln2 = Math.log(2);
        //求出二进制向量的长度
        bitSize = (int) (-(n * Math.log(p) / ln2 * ln2));
        //求出hash函数的个数
        hashSize = (int) (bitSize * ln2 / n);
        // bits数组的长度，计算公式类似于 pageCount 的公式(pageCount = (n+pageSize-1)/pageSize)
        bits = new long[(bitSize + Long.SIZE - 1) / Long.SIZE];
    }

    /**
     * 添加元素
     * @param value
     * @return
     */
    public boolean put(T value) {
        nullCheck(value);
        //对value生成hash值
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        boolean result = false;
        for (int i = 1; i <= hashSize; i++) {
            //尽可能生成不同的整数值
            int combineHash = hash1 + (i * hash2);
            if (combineHash < 0) {//保证生成的hash值大于零，如果小于零立马取反
                combineHash = ~combineHash;
            }
            //生成一个二进制位的index
            int index = combineHash % bitSize;
            result = set(index);
        }
        return result;
    }

    /**
     * 判断一个元素是否存在
     * @param value
     * @return
     */
    public boolean contains(T value) {
        nullCheck(value);
        int hash1 = value.hashCode();
        int hash2 = hash1 >>> 16;
        for (int i = 1; i <= hashSize; i++) {
            int combineHash = hash1 + (i * hash2);
            if (combineHash < 0) {
                combineHash = ~combineHash;
            }
            int index = combineHash % bitSize;
            if (!get(index)) return false;
        }
        return true;
    }

    private boolean get(int index) {
        long value = bits[index / Long.SIZE];
        // &操作：1&1=1,其他都是0
        return (value & (1 << (index % Long.SIZE))) != 0;
    }

    private boolean set(int index) {
        long value = bits[index / Long.SIZE];
        int bitValue = 1 << (index % Long.SIZE);
        // |操作：0|0=0,其他都是1
        bits[index/Long.SIZE] = value | bitValue;
        return  (value & bitValue) == 0;
    }

    private void nullCheck(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value must be not null.");
        }
    }

}

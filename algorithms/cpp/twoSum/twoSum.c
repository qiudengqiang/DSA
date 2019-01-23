//
//  TwoSum.c
//  Exam
//
//  Created by Apple on 2019/1/21.
//  Copyright © 2019 apple. All rights reserved.
//

/*
 题目描述:
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 
 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 eg:
 给定 nums = [2, 7, 11, 15], target = 9
 
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */

#include <stdio.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    //思路一：暴力双循环，时间复杂度O(N^2)
    /**
     为什么不加static就是错误的呢?
     因为如果不用静态的话，数组的声明周期就是从定义的地方到函数结束，函数运行结束，这个内存就释放掉了。返回的是数组的首地址，一旦函数运行结束，这个地址里面的东西就变成空的了，所以要用静态延长数组的声明周期。
     */
    static int result[2] = {0};
    for(int i = 0; i < numsSize-1; i++){
        for(int j = i + 1; j < numsSize; j++){
            if (nums[i] + nums[j] == target){
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    return 0;
}

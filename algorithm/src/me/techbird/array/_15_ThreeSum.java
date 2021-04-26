package me.techbird.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class _15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //找出和0的a、b、c
        Arrays.sort(nums);
        return threeSum(nums, 0);
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //穷举threeNum的第一个数
        for (int i = 0; i < n; i++) {
            //对target-nums[i] 计算twoSum
            List<List<Integer>> tuples = twoSum(nums, i + 1, target - nums[i]);
            //如果存在满足条件的二元组，再加上nums[i]就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //跳过第一个数组重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        //左指针改为start，其他不变
        int low = start, high = nums.length - 1;
        if (low < high) {
            int sum = nums[low] + nums[high];
            //remember value of low and high position
            int left = nums[low], right = nums[high];
            if (sum < target) {
                while (low < high && nums[low] == left) low++;
            } else if (sum > target) {
                while (low < high && nums[high] == right) right--;
            } else {
                ans.add(Arrays.asList(left, right));
                //while for distinct number
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) right--;
            }
        }
        return ans;
    }

    /**
     * 第二种解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(k > 0 && nums[k] == nums[k - 1]) continue;// 去重
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }


}

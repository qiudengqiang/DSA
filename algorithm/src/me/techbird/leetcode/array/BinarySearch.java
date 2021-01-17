package me.techbird.leetcode.array;

import me.techbird.leetcode.tool.Asserts;

/**
 * 二分查找的四种变体写法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8};

        Asserts.test(bSearchRecursion(a1, a1.length, 5) == 4);
        Asserts.test(bSearchNonRecursion(a1, a1.length, 5) == 4);
        Asserts.test(binary_search(a1, 5) == 4);

        int[] a2 = {
                1, 3, 4, 5, 6, 8, 8, 8, 11, 18
        };
        Asserts.test(binarySearch1(a2, a2.length, 8) == 5);
        Asserts.test(binarySearch2(a2, a2.length, 8) == 7);
        Asserts.test(left_bound(a2, 8) == 5);
        Asserts.test(right_bound(a2, 8) == 7);
        int[] a3 = {
                3, 4, 6, 7, 10
        };
        Asserts.test(binarySearch3(a3, a3.length, 5) == 2);
        int[] a4 = {
                3, 5, 6, 8, 9, 10
        };
        Asserts.test(binarySearch4(a4, a4.length, 7) == 2);
    }


    // 二分查找的递归实现
    public static int bSearchRecursion(int[] a, int n, int val) {
        return bSearchInternally(a, 0, n - 1, val);
    }

    private static int bSearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bSearchInternally(a, mid + 1, high, value);
        } else {
            return bSearchInternally(a, low, mid - 1, value);
        }
    }

    // 二分查找的非递归实现
    public static int bSearchNonRecursion(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体1：查找第一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 变体2：查找最后一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体3：查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体4：查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    /****以下为labuladong模板写法****/

    public static int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }


    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        //检查left边界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        //检查right边界
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}

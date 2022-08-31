package com.gzd.jksj.algo.binary;

/**
 * 二分查找
 *
 * @author guozhongdong
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        //System.out.println(binarySearch(nums, 9));
        //System.out.println(binarySearch2(nums, 5));
        //System.out.println(binarySearch3(nums, 5));
        //System.out.println(binarySearch4(nums, 4));
        System.out.println(binarySearch6(nums, 1));
        //System.out.println(binarySearch1(nums, 3, 0, nums.length - 1));
        //System.out.println(mySqrt(5));
    }

    /**
     * 从指定的数组中查找给定的数字
     */
    private static boolean binarySearch(int[] nums, int target) {
        if (nums == null) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 从指定的数组中查找给定的数字
     * 递归方式
     *
     */
    private static int binarySearch1(int[] nums, int target, int low, int high) {
        if (low >= high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target < nums[mid]) {
            return binarySearch1(nums, target, low, mid);
        } else if (target > nums[mid]) {
            return binarySearch1(nums, target, mid + 1, high);
        } else {
            return mid;
        }
    }

    /**
     * 求一个数的平方根，精确到小数点后6位
     * 精确，每次减半
     */
    private static double squortNum(int num) {
        // 如果和这个数是小数，直接取小数点后6位即可
        if (num > 0 && num < 1) {

        }
        return 0;
    }

    /**
     * 求解x的算术平方根，要求保留整数部分
     */
    public static int mySqrt(int x) {

        int low = 0;
        int n = x;
        // 结果
        int ans = -1;
        // 循环的终止条件
        while (low <= n) {
            int mid = low + (n - low) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                n = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 二分法变种问题，查找第一个元素等于目标元素的位置
     */
    private static int binarySearch2(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        // 1, 2, 3, 4, 5,5,5,5, 6, 7, 8
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return 0;
    }


    /**
     * 二分法变种问题，查找最后一个元素等于目标元素的位置
     */
    private static int binarySearch3(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        // 1, 2, 3, 4, 5,5,5,5, 6, 7, 8
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == high || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    /**
     * 二分法变种问题，查找第一个大于目标值的位置
     */
    private static int binarySearch4(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        // 1, 2, 3, 4, 5,5,5,5,5,5, 6, 7, 8
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                if (mid == 0 || nums[mid - 1] <= target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] <= target) {
                low = mid + 1;
            }
        }
        return 0;
    }

    /**
     * 二分法变种问题，查找最後一个小于等于于目标值的位置
     */
    private static int binarySearch5(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int high = nums.length - 1;
        int low = 0;
        // 1, 2, 3, 4, 5,5,5,5,5,5, 6, 7, 8
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] <= target) {
                if (mid == high || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    /**
     *
     * 如果有序数组是一个循环有序数组，比如 5，6，7，1，2，3，4。针对这种情况，如何实现一个求“值等于给定值”的二分查找算法呢？
     * 先确定一个有序区间，找到一个有序区间了，在进行二分查找
     * <p>
     * 解法1
     * <p>
     * <p>
     * 考虑好边界值
     * 循环退出条件
     * 比较的边界
     */
    private static int binarySearch6(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 从特征触发
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧区间有序
            if (nums[low] <= nums[mid]) {
                // 如果目标数在这区间，按二分查找继续
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    // 不在这区间，在右侧区间，设置好边界值，继续循环超找
                    low = mid + 1;
                }
            }
            // 右侧区间有序
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


}

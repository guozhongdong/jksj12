package com.gzd.jksj.algo.sort;

/**
 * 在一个无序数组中，求一个第K大的元素
 * O(N)的时间复杂度
 *
 * @author guozhongdong
 */
public class ParticeDemo {

    public static void main(String[] args) {

        int[] nums = {4, 2, 5, 12, 3};
        System.out.println(find(nums, 0, nums.length - 1, 3));
    }

    // 2 3 5 12 4
    //
    public static int find(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return 0;
        }
        int q = partition(nums, low, high);
        if (q + 1 == k) {
            return nums[q];
        } else if (q + 1 < k) {
            return find(nums, q + 1, high, k);
        } else {
            return find(nums, low, q - 1, k);
        }
    }

    /**
     * 找出无序数组中，第K大的元素
     * 分治，分区
     * 分区
     * 如果下标p +1 = k, 则p下标的元素，就是要炸的
     */
    public static int partition(int[] nums, int low, int high) {

        int num = nums[high];
        int p = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < num) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        int temp = nums[p];
        nums[p] = nums[high];
        nums[high] = temp;
        return p;
    }
}

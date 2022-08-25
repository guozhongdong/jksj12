package com.gzd.jksj.algo.sort;

import java.util.Random;

/**
 * 优化快排
 * 三数区中
 * 随机数
 *
 * @author guozhongdong
 */
public class OptimizeQuickSort {

    public static void main(String[] args) {
        int[] nums = {8, 10, 2, 3, 6, 1, 5};
        //merge(new int[nums.length],nums,0,3,nums.length);
        quickSort2(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition(nums, low, high);
        quickSort(nums, low, q - 1);
        quickSort(nums, q + 1, high);
    }

    // 分区
    private static int partition(int[] nums, int low, int high) {

        // 查找最后一个元素
        int num = nums[high];
        // 定义一个指针，左边是小于分区点的，右边是大于分区点的
        int p = low;
        // 开始比较交换数值
        for (int i = low; i < high; i++) {
            if (nums[i] < num) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        // 都交换完了，把分区点的数放到分区位置上
        int temp = nums[high];
        nums[high] = nums[p];
        nums[p] = temp;
        return p;

    }

    /**
     * 三数取中法
     */
    private static void quickSort1(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition1(nums, low, high);
        quickSort1(nums, low, q - 1);
        quickSort1(nums, q + 1, high);
    }

    // 分区
    private static int partition1(int[] nums, int low, int high) {

        // 三数取中，第一个，最后一个，中间一个
        int shou = nums[low];
        int num = nums[high];
        int mid = low + (high - low) / 2;
        int zhong = nums[mid];
        int mu = 0;
        if ((shou < num && shou > zhong) || (shou > num && shou < zhong)) {
            mu = shou;
            nums[low] = nums[high];
            nums[high] = mu;
        }
        if ((num < shou && num > zhong) || (num > shou && num < zhong)) {
            mu = num;
        }
        if ((zhong < num && zhong > shou) || (zhong > num && zhong < shou)) {
            mu = zhong;
            nums[mid] = nums[high];
            nums[high] = mu;
        }
        // 定义一个指针，左边是小于分区点的，右边是大于分区点的
        int p = low;
        // 开始比较交换数值
        for (int i = low; i < high; i++) {
            if (nums[i] < mu) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        // 都交换完了，把分区点的数放到分区位置上
        int temp = nums[high];
        nums[high] = nums[p];
        nums[p] = temp;
        return p;

    }

    /**
     * 随机数法
     */
    private static void quickSort2(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int q = partition2(nums, low, high);
        quickSort2(nums, low, q - 1);
        quickSort2(nums, q + 1, high);
    }

    // 分区
    private static int partition2(int[] nums, int low, int high) {

        // 随机法，随机找一个下标的数
        int rand = new Random().nextInt(high) % (high - low + 1) + low;
        int num = nums[rand];
        nums[rand] = nums[high];
        nums[high] = num;
        int p = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < num) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        int temp = nums[high];
        nums[high] = nums[p];
        nums[p] = temp;
        return p;
    }

}

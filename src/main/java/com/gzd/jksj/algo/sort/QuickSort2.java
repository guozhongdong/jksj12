package com.gzd.jksj.algo.sort;

/**
 * @author guozhongdong
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] nums = {8, 10, 2, 3, 6, 1, 5};
        //merge(new int[nums.length],nums,0,3,nums.length);
        quickSort2(nums, 0, nums.length - 1);

        System.out.println("");
        System.out.println("");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    // 分治
    private static void quickSort2(int[] nums, int low, int high) {
        // 递归的终止条件
        if (low >= high) {
            return;
        }
        // 找出分区的下标，
        int q = partition(nums, low, high);
        quickSort2(nums, low, q - 1);
        quickSort2(nums, q + 1, high);
    }
    // 分区
    private static int partition(int[] nums, int low, int high) {

        // 随机找一个分治点，或者默认最后一个元素
        int pivot = nums[high];
        // 定义一个指针，指向左边取件是比分区数小的，右边是比它大的
        int p = low;
        for (int i = low; i < high; i++) {
            // 如果当前i下标的元素比分区数小，则交换位置，将小的往前放
            // i代表数组本身的元素，i与p位置的元素进行交换
            // 交换完，p指向下一个元素，保证了左边肯定是小于分区数的
            if (nums[i] < pivot){
                // 此时
                 int temp = nums[i];
                 nums[i] = nums[p];
                 nums[p] = temp;
                 p++;
            }
        }
        // 走到这此时p位置的左侧肯定是比分区数小的，p位置的数也是大于分区数的，右侧肯定是比分区数大的
        // 将分区点的数据与p位置的数据交换，
        int temp = nums[p];
        nums[p] = nums[high];
        nums[high] = temp;
        return p;
    }
}

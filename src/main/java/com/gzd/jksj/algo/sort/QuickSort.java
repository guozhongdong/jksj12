package com.gzd.jksj.algo.sort;

/**
 * 快速排序
 *
 * @author guozhongdong
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {8,10,2,3,6,1,5};
        //merge(new int[nums.length],nums,0,3,nums.length);
        quickSort(nums, 0, nums.length - 1);
        System.out.println("");
        System.out.println("");
    }

    /**
     * 最经典的排序算法
     * 先找出分区点
     * 分区，
     * 8,10,2,3,6,1,5
     */
    private static void quickSort(int[] nums, int low, int high) {
        // 终止条件
        if (low >= high) {
            return;
        }
        // 先分区, 假如分区点是下标最后一位 ，值 5
        // 2 3 1 5 8 10 6
        int q = partition(nums, low, high);
        quickSort(nums, low, q-1);
        quickSort(nums, q + 1, high);
    }

    /**
     * 分区函数
     * 找出分区点，分区点左边的比它小，右边的比它大
     */
    public static int partition(int[] nums, int low, int high) {
        // 8,10,2,3,6,1,5
        // 取出分区点
        // 暂定最后一位
        int num = nums[high];
        // 比它大的放右边数组，比它小的放左边数组
        int p = low;
        // 不比较最后元素，因为它是分区点，最终要放到p指针所在的位置
        for (int i = low; i <= high-1; i++) {
            // 如果遇到比分区点小的数，将交换位置，p 和i的元素
            // p的前一位必须是比分区数小的
            if (nums[i] < num){
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;

            }
        }
        // 循环完了把分区点的数与p指针对应的数交换位置
        int temp = nums[p];
        nums[p] = nums[high];
        nums[high] = temp;
        return p;

    }

}

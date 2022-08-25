package com.gzd.jksj.algo.sort;

/**
 * 线性排序
 *
 * @author guozhongdong
 */
public class LinearSort {

    public static void main(String[] args) {
        int[] nums = {9, 2, 7, 65, 19, 78, 100, 30, 35, 40, 23, 55, 18};
        bucketSort(nums,30);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 桶排序
     * 排序年龄
     * 二位数组
     * 1、查找数据范围最小值和最大值
     * 2、遍历目标数据，分别放到对应的桶里
     * 3、对每个桶里的数据进行快速排序，
     * 4、按桶的下标依次取出数据
     *
     * @param bucketSize 桶容量
     */
    public static void bucketSort(int[] nums, int bucketSize) {

        // 构建桶
        // 默认人的年龄只到120岁
        // 计算桶的最小值和最大值，是为了确认数组的容量
        int min = nums[0];
        int max = nums[1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
            }else if (nums[i] >= max ){
                max = nums[i];
            }
        }
        int bucketCount = (max - min)/bucketSize +1;
        int[][] temp = new int[bucketCount][bucketSize];
        // 设置桶容量
        int[] indexArray = new int[bucketCount];
        // 遍历数据往桶里放
        for (int i = 0; i < nums.length; i++) {
            // 当前值的下标
            int buckIndex = (nums[i]-min)/bucketSize;
            temp[buckIndex][indexArray[buckIndex]++] = nums[i];
        }
        // 对桶里的数据进行快速排序
        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            if (indexArray[i] != 0){
                quick(temp[i], 0, indexArray[i] - 1);
                for (int m = 0; m < indexArray[i]; m++) {
                    nums[k++] = temp[i][m];
                }
            }
        }
    }

    private static void quick(int[] nums, int low, int high){
        if (low >= high){
            return;
        }
        int q = partition(nums,low,high);
        quick(nums,low,q-1);
        quick(nums,q+1,high);
    }

    /**
     * 分区
     */
    private static int partition(int[] nums, int low, int high) {

        int num = nums[high];
        int p = low;
        for (int i = low; i < high; i++) {
            // 比分区点的数小，放左边
            if (nums[i] < num){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        // 把num放到p指针的地方
        int temp = nums[p];
        nums[p] = nums[high];
        nums[high] = temp;
        return p;
    }
}

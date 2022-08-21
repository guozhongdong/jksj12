package com.gzd.jksj.algo.sort;

/**
 * 冒泡排序
 *
 * @author guozhongdong
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 7, 1, 9, 6, 4};
        insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            // 取第一个元素，作为已排序区间的元素
            // 5,2,7,1,9,6,4
            int num = nums[i];
            // num = 1
            // 2 5 7
            // 2 5 1 7
            int j = i - 1;
            // 下面和这个循环是操作已排序区间的
            for (; j >= 0; j--) {
                if (num < nums[j]) {
                    // 数据移动
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            // 赋值数据
            nums[j+1] = num;
        }
    }
}

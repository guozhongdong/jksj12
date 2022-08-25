package com.gzd.jksj.algo.sort;

/**
 * 冒泡排序
 *
 * @author guozhongdong
 *
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {2,5,7,1,9,6,4};
        selectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 选择排序
     * 每次在未排序区间选择最小的元素，放到已排序区间的末尾
     */
    public static void selectSort(int[] nums){

        for (int i = 0; i < nums.length-1; i++) {

            // 目前是已排序区间的末尾，如果找到最小的元素，则交换值
            int min = i;
            //2,5,7,1,9,6,4
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            // 交换元素
            // 最小值
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }
}

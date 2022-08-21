package com.gzd.jksj.algo.sort;

/**
 * 冒泡排序
 *
 * @author guozhongdong
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {2,5,7,1,9,6,4};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] nums){

        boolean flag =false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    /**
     * 冒泡排序优化
     */
    public static void bubbleSort2(int[] nums){

        boolean flag =false;

        int lastChange = 0;

        int sortBoundary = nums.length -1;


        for (int i = 0; i < nums.length; i++) {

            // 定义每次比较元素的一个边界值

            for (int j = 0; j < sortBoundary; j++) {

                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                    sortBoundary = j;
                }
            }
            sortBoundary = lastChange;
            if (!flag){
                break;
            }
        }
    }
}

package com.gzd.jksj.algo.sort;

/**
 * 基数排序
 *
 * @author guozhongdong
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] nums = {221, 321, 421,235, 123};
        radixSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static void radixSort(int[] arr) {
        // 找到一个最大值 ，决定计数数组的个数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 从个位开始，对arr进行指数排序
        for (int i = 1; max / i > 0; i = i * 10) {
            countSort(arr, i);
        }
    }
    /**
     * 计数排序
     *
     */
    private static void countSort(int nums[], int erp) {

        // 每一位只有10个数，记录每个数出现的个数
        int[] temp = new int[10];
        for (int i = 0; i < nums.length; i++) {
            temp[(nums[i]/erp)%10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < temp.length; i++) {
            temp[i] += temp[i - 1];
        }
        
        //定义一个临时数组
        int[] r = new int[nums.length];
        for (int i = nums.length-1 ; i >=0; i--) {
            int shu = (nums[i]/erp)%10;
            int index = temp[shu];
            temp[shu]--;
            r[index-1] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = r[i];
        }
    }
}

package com.gzd.jksj.algo.sort;

/**
 * 计数排序
 *
 * @author guozhongdong
 */
public class CountSort {

    public static void main(String[] args) {
        // 原始数组
        int[] nums = {2, 5, 3, 0, 2, 3, 0, 3};
        countSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void countSort(int[] nums) {

        // 通过一个最大值和最小值构建一个存次数的数组
        int min = nums[0];
        int max = nums[1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] >= max) {
                max = nums[i];
            }
        }
        // 求数组的元素
        int index = (max - min) + 1;
        // 这个数组里存元素出现的次数，下标达标元素
        int[] temp = new int[index];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] += 1;
        }
        // 将temp数组顺序求和,精髓所在啊
        // a[i] = a[i]+ a[i-1]
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        // 此时temp数组里存的是 小于等于当前下标数的个数
        // 从后往前遍历原数组，将元素放到一个新的有序数组里
        // 声明一个新的有序数组
        int[] result = new int[nums.length];
        // 从后往前取
        // 2,5,3,0,2,3,0,3
        for (int i = nums.length - 1; i >= 0; i--) {

            int shu = nums[i];
            // 找到这个数字在temp数组中对应的位置，拿到位置后放到有序数组
            int weizhi = temp[shu];
            temp[shu] -= 1;
            result[weizhi - 1] = shu;
        }
        System.out.println("");
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}

package com.gzd.jksj.algo.sort;

/**
 * 归并排序
 *
 * @author guozhongdong
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {11, 8,3, 9, 7, 1,2, 5};
        //merge(new int[nums.length],nums,0,3,nums.length);
        mergeSort(nums, 0, nums.length-1);
        System.out.println("");
        System.out.println("");
    }

    /**
     * 计算出递推公式
     * 找出终止条件
     */
    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 找一个中点
        int mid = low + (high - low) / 2;
        // 递归左半部分
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        // 递归右半部分
        // 11 8 3 9 7 1 2 5

        // 11 8
        // 3 9
        merge(nums, low, mid, high);

    }

    /**
     * 合并两个有序数组
     * 定义两个指针 i j，分别指向两个有序数组，
     * <p>
     * 11 8 3 9 7 1 2 5
     *
     * 11 8
     */
    public static void merge( int[] nums, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[high-low+1];
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 判断两个子数组，哪个里面还有数据
        int start = i;
        int end = mid;
        if (j <= high) {
            start = j;
            end = high;
        }
        for (int l = start; l <= end; l++) {
            temp[k++] = nums[l];
        }
        // 将临时数组里的数据转到原数组，注意下标的节点
        for (int l = 0; l < temp.length; l++) {
            nums[low + l] = temp[l];
        }
    }
}

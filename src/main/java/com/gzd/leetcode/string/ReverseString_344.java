package com.gzd.leetcode.string;

/**
 * @author guozhongdong
 */
public class ReverseString_344 {

    public static void main(String[] args) {
        ReverseString_344 reverseString = new ReverseString_344();
        char[] s = {'h','e','l','l','o'};
        reverseString.reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]+" ");
        }
    }
    //  双指针交换
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}

package com.gzd.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * @author guozhongdong

 */
public class Yanghuisanjiao_118 {

    public static void main(String[] args) {
        Yanghuisanjiao_118 yang = new Yanghuisanjiao_118();
        List<List<Integer>> list = yang.generate(5);
        System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        if (numRows == 1){
            list1.add(1);
            list.add(list1);
            return list;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list2 = new ArrayList<>();
            // 1 ,1 1, 1 2 1 , 1 3 3 1
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list2.add(1);
                }else {
                    System.out.println(list.get(i-1));
                    list2.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(list2);

        }
        return list;
    }
}

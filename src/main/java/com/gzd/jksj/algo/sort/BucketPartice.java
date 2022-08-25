package com.gzd.jksj.algo.sort;

/**
 * 桶排序联系
 *
 * @author guozhongdong
 */
public class BucketPartice {

    public static void main(String[] args) {
        select("DaFB5634cAz23");
    }
    // 字符串里的大写字母，小写字母，数字，按顺序排列，内部不要求排列
    //
    public static void select(String str){
        if (str == null){
            return;
        }
        // 直接构建一个桶
        char[][] bucks = new char[3][str.length()];
        int l = 0;
        int m = 0;
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                bucks[1][l++] = str.charAt(i);
            }else if (Character.isUpperCase(str.charAt(i))){
                bucks[2][m++] = str.charAt(i);
            }else{
                bucks[0][n++] = str.charAt(i);
            }
        }

        // 输出
        for (int i = 0; i < bucks.length; i++) {
            char[] data = bucks[i];
            if (data[i] != 0){
                for (int j = 0; j < data.length; j++) {
                    if (data[j] == 0){
                        continue;
                    }
                    System.out.print(data[j]+" ");
                }
            }
        }

    }
}

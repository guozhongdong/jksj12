package com.gzd.leetcode.string.digit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhongdong
 */
public class FizzBuzz_412 {

    public static void main(String[] args) {

        FizzBuzz_412 fizzBuzz = new FizzBuzz_412();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while (i <= n) {

            if ((i%3==0) && (i%5==0)){
                list.add("FizzBuzz");
            }else if (i%3==0){
                list.add("Fizz");
            }else if (i%5==0){
                list.add("Buzz");
            }else {
                list.add(i+"");
            }
            i++;
        }
        return list;

    }


}

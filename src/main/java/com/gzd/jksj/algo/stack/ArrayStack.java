package com.gzd.jksj.algo.stack;

import javafx.scene.chart.PieChart;

/**
 * 数组实现栈
 *
 * @author guozhongdong
 */
public class ArrayStack {

    // 容量
    int capacity;

    // 数据载体
    String[] data;

    // 弹出的下标
    int count;


    public ArrayStack(int cap) {
        this.capacity = cap;
        data = new String[cap];
        this.count = 0;
    }

    // 入栈
    public boolean push(String str) {

        if (count >= capacity){
            return false;
        }
        data[count++] = str;
        return true;
    }

    // 出栈
    public String pop() {
        if (count == 0){
            return null;
        }
        String s = data[count-1];
        data[count-1] = null;
        count--;
        return s;
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);
        stack.push("a1");
        stack.push("a2");
        stack.push("a3");
        stack.push("a4");
        stack.push("a5");
        System.out.println(stack.count);
        System.out.println(stack.pop());
        System.out.println(stack.count);
        System.out.println(stack.pop());
        System.out.println(stack.count);
    }
}

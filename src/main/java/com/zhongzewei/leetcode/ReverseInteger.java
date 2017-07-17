package com.zhongzewei.leetcode;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 Note:
 The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * Created by zhongz on 2017/7/17.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(1));
    }

    public static int reverseInteger(int x) {
        char[] digits = String.valueOf(Math.abs(x)).toCharArray();
        int len = digits.length;
        int j = len -1;
        for (int i = 0; i < j; i++, j--) {
            swap(digits, i, j);
        }
        int res = 0;
        try {
            res = Integer.parseInt(new String(digits));
        } catch (Exception e) {

        }
        return x < 0? -res:res;
    }

    private static void swap(char[] data, int i, int j) {
        char tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

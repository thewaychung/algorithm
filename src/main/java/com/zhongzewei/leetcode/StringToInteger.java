package com.zhongzewei.leetcode;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 * Created by zhongz on 2017/7/17.
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("+124"));
        System.out.println(myAtoi("-123"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("23s"));
        System.out.println(myAtoi("34238975834758734875"));
        System.out.println(myAtoi("-34238975834758734875"));
    }

    private static int myAtoi(String str) {
        if(str == null || str.length() < 1) {
            return 0;
        }

        int len = str.length(), result = 0, sign = 1, index = 0;
        while(str.charAt(index) == ' ' && index < len)
            index++;
        char first = str.charAt(index);
        if(first < '0' || first > '9') {
            if(first=='-'){
                sign = -1;
            } else if(first=='+'){
                sign = 1;
            } else {
                return 0;
            }
            index++;
        }

        while(index < len) {
            int digit = Character.digit(str.charAt(index),10);
            if(digit < 0)
                return sign * result;
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10))
                return sign > 0 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            result = result*10 + digit;
            index++;
        }
        return sign * result;
    }
}

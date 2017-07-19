package com.zhongzewei.general;

/**
 * 爬楼梯：有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
 *
 * Created by zhongz on 2017/7/19.
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.print(climbStairs(10));
    }

    private static int climbStairs(int nums) {
        int a = 1, b =2, val = 0;
        for (int i = 3; i <= nums; i++) {
            val = a + b;
            a = b;
            b = val;
        }
        return val;
    }
}

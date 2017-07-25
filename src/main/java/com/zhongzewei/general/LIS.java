package com.zhongzewei.general;

/**
 * Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 *
 * Created by Zhong.Zewei on 2017/7/25.
 */
public class LIS {

    public static void main(String[] args) {
        int[] data = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("input [10, 9, 2, 5, 3, 7, 101, 18] LIS:");
        System.out.println(lis(data));
    }

    //时间复杂度：O(N^2)，空间复杂度：O(N)
    private static int lis(int[] data) {
        if(data==null || data.length<1) return 0;
        int[] dp = new int[data.length+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 1; i<data.length; i++) {
            dp[i+1]=1;
            for (int j=0; j<i; j++) {
                if (data[i]>=data[j]) {
                    dp[i+1] = Math.max(dp[i+1], dp[j+1]+1);
                }
            }
        }
        return dp[data.length];
    }
}

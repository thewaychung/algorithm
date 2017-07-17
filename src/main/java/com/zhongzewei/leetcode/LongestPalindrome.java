package com.zhongzewei.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 * Created by zhongz on 2017/7/17.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccbadef";
        System.out.println(longestPalindrome(s));
        System.out.print(Math.abs(123));
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        int len = s.length();
        while (L >= 0 && R < len && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L -1;
    }
}

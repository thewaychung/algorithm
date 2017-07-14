package com.zhongzewei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by zhongz on 2017/7/14.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("aa");
        System.out.print(len);
    }

    //算法思路：用一个Map来存储char-index，对字符串进行遍历，如果map中存在该key，则从上一次出现该key的index后一位开始继续往后遍历。
    private static int lengthOfLongestSubstring(String s) {
        int len = 0;
        if (s == null || s.length() < 1) {
            return len;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int tmpLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                len = (tmpLen > len) ? tmpLen : len;
                i = map.get(c);
                map.clear();
                tmpLen = 0;
            } else {
                map.put(c, i);
                tmpLen++;
            }
        }

        return (tmpLen > len) ? tmpLen : len;
    }
}

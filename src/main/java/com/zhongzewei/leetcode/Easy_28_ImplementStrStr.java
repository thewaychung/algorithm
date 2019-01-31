package com.zhongzewei.leetcode;

/**
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 * @author Zhong.Zewei
 * @date 2019/1/31
 */
public class Easy_28_ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle == null) {
            return 0;
        }

        for (int i=0; ;i++) {
            for (int j=0; ;j++) {
                //如果needle已经到最后了，则证明needle被包含在haystack中
                if (j==needle.length()) {
                    return i;
                }
                //如果haystack到最后了，则证明needle不在haystack中
                if (i+j==haystack.length()) {
                    return -1;
                }
                //如果当前位不一致，则从haystack的下一位开始遍历
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}

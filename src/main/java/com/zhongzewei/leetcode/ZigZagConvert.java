package com.zhongzewei.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * Created by zhongz on 2017/7/17.
 */
public class ZigZagConvert {

    public static void main(String[] args) {
        String s = "ABCEDFG";
        System.out.print(zigZagConvert(s, 3));
    }

    public static String zigZagConvert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int len = s.length();
        int k = 0;
        while (k < len) {
            //往下
            for (int i = 0; i < numRows && k < len; i++) {
                sb[i].append(s.charAt(k++));
            }
            //往上
            for (int i = numRows -2; i >= 1 && k < len; i--) {
                sb[i].append(s.charAt(k++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}

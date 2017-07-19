package com.zhongzewei.general;

/**
 * Longest Common Sequence
 *
 * Created by zhongz on 2017/7/19.
 */
public class LCS {

    public static void main(String[] args) {
        System.out.println(lcs("aa", "ab")); //1
        System.out.println(lcs("aefa;jkfa", "eaajkaf"));//5
        System.out.println(lcs("BDCABA", "ABCBDAB"));//4
    }

    private static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] c = new int[m + 1][n +1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    c[i][j] = 0;
                else if (s1.charAt(i-1)==s2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else
                    c[i][j] = Math.max(c[i][j-1], c[i-1][j]);
            }
        }
        return c[m][n];
    }
}

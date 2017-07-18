package com.zhongzewei.general;

/**
 * 给定一段字符串，如ab%sdf$%ez，返回该字符串有几段字母。如该例中有三段。
 *
 * Created by zhongz on 2017/7/18.
 */
public class CountCharacter {

    public static void main(String[] args) {
        System.out.println(countCharacter("aa"));
        System.out.println(countCharacter("%%0"));
        System.out.println(countCharacter("a%"));
        System.out.println(countCharacter("aa%bad$##$s"));
        System.out.println(countCharacter("$%^a"));
    }

    //算法思路：首次出现字母时，计数器自动加一，一直等到出现符号之后，可再次开始计数。
    //因此使用一个标志位，用来标志何时可以计数。
    private static int countCharacter(String s) {
        int count = 0;
        if (s == null || s.length() < 1) {
            return count;
        }
        int len = s.length();
        boolean canPromote = true;
        for (int i = 0; i<len; i++) {
            char c = s.charAt(i);
            //c >= 'A' && c <= 'z'
            if (Character.isLetter(c)) {
                if (canPromote) {
                    count++;
                    canPromote = false;
                }
            } else {
                canPromote = true;
            }
        }
        return count;
    }
}

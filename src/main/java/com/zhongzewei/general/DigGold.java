package com.zhongzewei.general;

/**
 * 挖金矿：有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
 * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * （金矿的情况G[0]=500金5人，G[1]=200金3人，G[2]=300金4人，G[3]=350金3人，G[4]=400金5人）
 *
 * Created by zhongz on 2017/7/19.
 */
public class DigGold {

    public static void main(String[] args) {
        int[] g = new int[10];
        int[] p = new int[10];
        g[0] = 400; p[0] = 5;
        g[1] = 500; p[1] = 5;
        g[2] = 200; p[2] = 3;
        g[3] = 300; p[3] = 4;
        g[4] = 350; p[4] = 3;
        //todo 得到的该结果存疑
        System.out.print(getMostGold(5, 10, g, p));
    }

    //n:金矿数量，w:工人数量，g：金矿序号与含金量，p：金矿序号与所需人数
    private static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResult = new int[w+1];
        int[] result = new int[w+1];

        //边界条件，挖1座金矿
        for (int i = 1; i <= w; i++) {
            if (i < p[0]) {
                preResult[i] = 0;
                System.out.print(preResult[i] + " ");
            } else {
                preResult[i] = g[0];
                System.out.print(preResult[i] + " ");
            }
        }
        System.out.println();

        //从第两座金矿开始
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i]) {
                    result[j] = preResult[j];
                } else {
                    result[j] = Math.max(preResult[j], preResult[j - p[i]] + g[i]);
                }
                System.out.print(result[j] + " ");
            }
            preResult = result;
            System.out.println();
        }
        return result[w];
    }
}

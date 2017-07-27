package com.zhongzewei.sort;

/**
 * 希尔排序
 * Created by Zhong.Zewei on 2017/7/25.
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] data = {1,3,2,3,9,4,5,8,7,6};
        shellSort(data);
        for(int val : data) {
            System.out.print(val + ",");
        }
    }

    //时间复杂度：O(NlogN)
    private static void shellSort(int[] data) {
        int gap = data.length/2;
        while (gap >= 1) {
            //把距离为 gap 的元素编为一组，扫描所有的组
            for (int i=gap; i<data.length; i++) {
                //对距离为 gap 的元素进行排序
                for (int j=i-gap; j>=0 && data[j]>data[j+gap]; j=j-gap) {
                    //swap(data, j, j+gap);
                    int tmp = data[j];
                    data[j] = data[j+gap];
                    data[j+gap] = tmp;
                }
            }
            //减小增量
            gap = gap/2;
        }
    }
}

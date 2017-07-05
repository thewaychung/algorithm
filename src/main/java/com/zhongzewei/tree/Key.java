package com.zhongzewei.tree;

/**
 * 可比较的键
 * Created by zhongz on 2017/7/5.
 */
public class Key implements Comparable {
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }

        if (this.equals(o)) {
            return 0;
        }

        return this.hashCode() > o.hashCode() ? 1 : -1;
    }
}

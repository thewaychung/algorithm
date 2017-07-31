package com.zhongzewei.tree;

/**
 * 二叉树节点
 * Created by Zhong.Zewei on 2017/7/31.
 */
public class TreeNode {

    Key key;
    Object value;
    TreeNode left, right;//左右子节点
    int N;//以该节点为根的子树节点总数

    public TreeNode(Key key, Object value, int N) {
        this.key = key;
        this.value = value;
        this.N = N;
    }
}

package com.zhongzewei.tree;

/**
 * 二叉查找树
 *
 * 定义：二叉查找树是二叉树，每个节点都有一个Comparable的键，且每个节点的键都大于其左子树中任意节点的键，
 * 而小于右子树任意节点的键。
 *
 * 算法描述：如果树是空的，则查找未命中。用查找的键与当前根节点的键比较，如果查找键较小，就选择左子树继续查找，
 * 如果查找键较大，就选择右子树继续查找，如果相等则查找命中。
 *
 * 时间复杂度：lgN
 *
 * Created by zhongz on 2017/7/5.
 */
public class BinarySearchTree {

    private Node root;

    public Object get(Key key) {
        return get(root, key);
    }

    //二叉查找树：查找key对应的值
    private Object get(Node x, Key key) {
        //在以x为根节点的子树中查找并返回key对应的值
        //若x为空，代表没找到，返回null
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        }
        return x.value;
    }

    //二叉查找树：插入键值对
    private Node put(Node x, Key key, Object value) {
        //在以x为根节点的子树中插入键值
        //若x为空，代表子树中不存在该键，则插入新节点
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            return x.right = put(x.right, key, value);
        }
        x.value = value;
        x.N = x.left.N + x.right.N + 1;
        return x;
    }

    //节点
    public class Node {
        Key key;
        Object value;
        Node left, right;//左右子节点
        int N;//以该节点为根的子树节点总数

        public Node(Key key, Object value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}

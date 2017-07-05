package com.zhongzewei.tree;

/**
 * 红黑二叉查找树
 *
 * 需要满足以下三个条件：
 * - 红链接均为左链接；
 * - 没有任何一个节点同时和两条红链接相连；
 * - 任意空链接到根节点路径上的黑链接数相同（完美黑色平衡）；
 *
 * Created by zhongz on 2017/7/5.
 */
public class RedBlackBST {

    private final boolean RED = true;
    private final boolean BLACK = false;

    private Node root;

    public void put(Key key, Object val) {
        root = put(root, key, val);
        root.color = BLACK; //插入后总是将根节点设置为黑色
    }

    //红黑树插入算法
    public Node put(Node h, Key key, Object val) {
        //标准插入操作，和父节点用红色链接相连
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        //递归调用插入该键值
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        }
        h.value = val;
        //判断红黑树插入键值后是否仍然保持平衡
        //1.如果右子节点是红色，左子节点是黑色，左旋
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        //2.如果左子节点及其左子节点均为红色，右旋
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        //3.如果左右子节点均为红色，颜色转换
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = h.left.N + h.right.N + 1;
        return h;
    }

    //左旋:右子节点为红色
    private Node rotateLeft(Node h) {
        Node r = h.right;
        h.right = r.left;
        r.left = h;
        r.color = h.color;
        h.color = RED;

        r.N = h.N;
        h.N = h.left.N + h.right.N + 1;
        return r;
    }

    //右旋:左子节点及左子节点的左子节点均为红色
    private Node rotateRight(Node h) {
        Node l = h.left;
        h.left = l.right;
        l.right = h;
        l.color = h.color;
        h.color = RED;

        l.N = h.N;
        h.N = h.left.N + h.right.N + 1;
        return l;
    }

    //颜色转换:左右子节点均为红色
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //判断一个节点是否为红色
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private class Node {
        Key key;
        Object value;
        boolean color;//父节点指向该节点的链接颜色
        int N; //该子树的节点总数
        Node left, right; //左右子节点

        public Node(Key key, Object value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
}

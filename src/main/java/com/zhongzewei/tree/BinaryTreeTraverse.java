package com.zhongzewei.tree;

import java.util.LinkedList;

/**
 * 二叉树遍历：前序遍历（父前）、后续遍历（父后）、中序遍历（父中）、层次遍历
 * Created by Zhong.Zewei on 2017/7/31.
 */
public class BinaryTreeTraverse {

    //前序遍历：根节点->左子树->右子树(递归实现)
    public void preorderTraverse(BinarySearchTree.Node root) {
        if(root!=null) {
            System.out.println(root.value);
            preorderTraverse(root.left);
            preorderTraverse(root.right);
        }
    }

    //后序遍历：左子树->右子树->根节点(递归实现)
    public void postorderTraverse(BinarySearchTree.Node root) {
        if(root!=null) {
            postorderTraverse(root.left);
            postorderTraverse(root.right);
            System.out.println(root.value);
        }
    }

    //中序遍历：左子树->根节点->右子树(递归实现)
    public void inorderTraverse(BinarySearchTree.Node root) {
        if(root!=null) {
            inorderTraverse(root.left);
            System.out.println(root.value);
            inorderTraverse(root.right);
        }
    }

    //层次遍历：自顶向下，从左到右逐层访问每个节点
    public void levelTraverse(BinarySearchTree.Node root) {
        if(root!=null) {
            LinkedList<BinarySearchTree.Node> queue = new LinkedList<BinarySearchTree.Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinarySearchTree.Node node = queue.poll();
                System.out.println(node.value);
                if (node.left !=null) queue.add(node.left);
                if (node.right !=null) queue.add(node.right);
            }
        }
    }
}

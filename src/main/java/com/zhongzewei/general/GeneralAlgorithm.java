package com.zhongzewei.general;

import com.zhongzewei.common.Node;

/**
 * 一些常见的算法
 * Created by zhongz on 2017/7/13.
 */
public class GeneralAlgorithm {

    /**
     * 有序链表去重：递归算法
     */
    private Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.next.equals(head.next.next) ? head.next : head;
    }
}

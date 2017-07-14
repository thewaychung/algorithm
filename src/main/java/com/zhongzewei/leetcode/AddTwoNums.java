package com.zhongzewei.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * Created by zhongz on 2017/7/14.
 */
public class AddTwoNums {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(3);
        ListNode result = addTwoNumbers(l1, l2);
        while (result!=null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode n1 = l1, n2 = l2, currentNode = result;
        while (n1 != null || n2 != null) {
            int val = currentNode.val;
            if (n1 != null) {
                val += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                val += n2.val;
                n2 = n2.next;
            }

            int nextVal = 0;
            if (val > 9) {
                currentNode.val = val % 10;
                nextVal = val / 10;
            } else {
                currentNode.val = val;
            }

            if (n1 != null || n2 != null || nextVal > 0) {
                currentNode.next = new ListNode(nextVal);
                currentNode = currentNode.next;
            }
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}

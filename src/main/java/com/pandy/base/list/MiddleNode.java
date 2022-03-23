package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/1/9
 * 求链表的中间节点
 **/
public class MiddleNode {
    private static ListNode getMiddle(ListNode root) {
        if (root == null) return null;
        ListNode slow = root;
        ListNode fast = root;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

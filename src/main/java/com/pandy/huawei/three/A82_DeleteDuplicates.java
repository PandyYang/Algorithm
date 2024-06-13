package com.pandy.huawei.three;

import com.pandy.common.ListNode;

/**
 * 删除链表中的重复元素II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class A82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        if (next.val == head.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }

            head = deleteDuplicates(next);
        } else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

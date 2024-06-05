package com.pandy.huawei.shousi;

import com.pandy.common.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        // 快慢指针找到链表的中间节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割链表
        ListNode mid = slow.next;
        slow.next = null;

        // 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 合并已排序的两部分
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 连接剩余的节点
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/1/3
 * 合并两个有序的链表
 *
 * 使用递归的方式
 **/
public class MergeList {
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    private static ListNode merge2(ListNode a, ListNode b) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode head = a.val > b.val ? b : a;
        ListNode index1 = head.next;
        ListNode index2 = head == a ? b : a;
        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                head.next = (index1);
                index1 = index1.next;
            } else {
                head.next = (index2);
                index2 = index2.next;
            }
            head = head.next;
        }
        if (index1 == null) {
            while (index2 != null) {
                head.next = (index2);
                index2 = index2.next;
                head = head.next;
            }
        } else {
            while (index1 != null) {
                head.next = (index1);
                index1 = index1.next;
                head = head.next;
            }
        }
        return a.val > b.val ? b : a;
    }
}

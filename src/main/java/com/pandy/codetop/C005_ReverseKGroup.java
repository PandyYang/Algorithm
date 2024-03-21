package com.pandy.codetop;

import com.pandy.common.ListNode;

public class C005_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preGroupEnd = dummy;

        // 找到第k个节点
        while (head != null) {
            ListNode tail = head;
            int count = 1;
            while (tail != null && count < k) {
                tail = tail.next;
                count++;
            }
            if (tail == null) break; // 不足k个不要翻转
            ListNode nextGroupStart = tail.next;

            // 翻转当然k个节点
            ListNode[] reverseResult = reverse(head, tail);
            head = reverseResult[0];
            tail = reverseResult[1];

            // 连接前一组的尾部与当前组的头部
            preGroupEnd.next = head;
            // 连接当前组的头部和下一组的尾部
            tail.next = nextGroupStart;

            // 准备处理下一组
            preGroupEnd = tail;
            head = nextGroupStart;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return new ListNode[]{tail, head};
    }
}

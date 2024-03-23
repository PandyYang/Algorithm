package com.pandy.codetop;

import com.pandy.common.ListNode;

public class C021_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // 先到达left
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        head = pre.next;
        for (int i = left; i < right; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}

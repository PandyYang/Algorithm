package com.pandy.codetop;

import com.pandy.common.ListNode;

// 删除链表倒数第k个节点
public class C027_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

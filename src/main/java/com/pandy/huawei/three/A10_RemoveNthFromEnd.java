package com.pandy.huawei.three;

import com.pandy.common.ListNode;

public class A10_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

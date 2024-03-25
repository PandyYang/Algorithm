package com.pandy.codetop;

import com.pandy.common.ListNode;

public class C025_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        // 检测环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

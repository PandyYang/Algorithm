package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/7/1
 **/
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode prev = null;
        while (fast != null) {
            // 记录slow当前的点
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        // 相当于辅助了一个slow = slow.next
        prev.next = slow.next;
//        slow.next = null;

        return dummy.next;

    }
}

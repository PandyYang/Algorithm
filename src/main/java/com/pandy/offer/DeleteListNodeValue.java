package com.pandy.offer;

import com.pandy.common.ListNode;

public class DeleteListNodeValue {
    public ListNode delete(ListNode head, int value) {
        if (head == null) {
            return null;
        }

        if (head.val == value) {
            return head.next;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}

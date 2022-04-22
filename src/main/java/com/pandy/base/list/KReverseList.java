package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/4/21
 **/
public class KReverseList {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0), prev = dummy, curr = head, next;

        dummy.next = head;

        int length = 0;

        while(head != null) {
            length++;
            head = head.next;
        }

        head = dummy.next;

        for(int i = 0; i < length / k; i++) {
            for(int j = 0; j < k - 1; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
}

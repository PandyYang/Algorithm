package com.pandy.codetop;

import com.pandy.common.ListNode;

public class C042_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;
        while(p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x +y;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0) curr.next = new ListNode(carry);
        return dummy.next;
    }
}

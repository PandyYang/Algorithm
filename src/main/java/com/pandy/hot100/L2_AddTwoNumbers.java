package com.pandy.hot100;

import com.pandy.common.ListNode;

public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 边界条件
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
//        ListNode p = l1, q = l2, cur=dummy;
        ListNode cur = dummy;
        int curry = 0;
        while (l1 != null || l2 != null) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int sum = num2 + num1 + curry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            curry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (curry > 0) {
            cur.next = new ListNode(curry);
        }
        return dummy.next;
    }
}

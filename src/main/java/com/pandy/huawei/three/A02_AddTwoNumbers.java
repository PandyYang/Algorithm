package com.pandy.huawei.three;

import com.pandy.common.ListNode;

public class A02_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(6);

        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        ListNode l = new A02_AddTwoNumbers().addTwoNumbers(a1, b1);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }

    }
}

package com.pandy.huawei.three;

import com.pandy.common.ListNode;

public class A206_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur;
        ListNode pre = null;
        cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

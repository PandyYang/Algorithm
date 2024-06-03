package com.pandy.hot100;

import com.pandy.common.ListNode;
import jdk.nashorn.internal.ir.LiteralNode;

public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur !=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

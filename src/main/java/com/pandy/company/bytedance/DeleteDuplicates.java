package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/6/30
 *
 * 删除链表中的重复元素
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {

                // 记录重复值 一直向前
                int x = cur.next.val;

                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }

            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

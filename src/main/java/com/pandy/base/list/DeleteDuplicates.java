package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 16/6/2022
 * <p>
 * 删除链表中重复的元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 16/6/2022
 *
 * 删除链表中重复的元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode cur = head;
        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    // 删除重复的链表元素 只保留出现一次的
    public ListNode deleteDuplicates2(ListNode head) {
        // write code here
        if (head == null) return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 记录重复的节点
                int temp = cur.next.val;
                // 将所有的重复的都跳过
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur .next;
            }
        }
        return res.next;
    }
}

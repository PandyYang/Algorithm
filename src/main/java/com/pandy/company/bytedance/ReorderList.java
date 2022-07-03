package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

import java.util.LinkedList;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 重排链表
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;

        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }

        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }

        if (cur != null) {
            cur.next = null;
        }
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.LinkedList;

/**
 * @author: Pandy
 * @create: 2022/6/28
 **/
public class ReorderList {

    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;

        // 全部节点入列
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }

        while (!queue.isEmpty()) {

            // 第一个节点
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                // 头
                cur.next = queue.pollFirst();
                cur = cur.next;
            }

            // 插尾
            cur.next = queue.pollLast();
            cur = cur.next;
        }

        if (cur != null) {
            cur.next = null;
        }
    }
}

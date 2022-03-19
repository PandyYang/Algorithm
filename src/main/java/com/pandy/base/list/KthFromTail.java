package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/1/9
 * 打印倒数第k个节点
 **/
public class KthFromTail {
    private static Integer kthFromTail(ListNode a, int k) {
        if (a == null) return null;
        if (k == 0) {
            return null;
        }

        ListNode node1 = a;
        ListNode node2 = null;
        // 快链表先走k步
        for (int i = 0; i < k - 1; i++) {
            if (node1.next == null) {
                // k比链表的长度大
                return null;
            }
            node1 = node1.next;
        }

        // node1是快指针 先走k步
        // node2从头出发
        node2 = a;

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2.val;
    }
}

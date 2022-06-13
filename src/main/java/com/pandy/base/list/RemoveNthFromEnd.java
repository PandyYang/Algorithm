package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/3/24
 *
 * 删除倒数第n个节点
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 一定要定义虚拟节点 要是删除了头节点就不好办了
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // 找到第n个节点
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // 计算倒数第N个，顺数是第几个：size - N + 1
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 删除节点
        second.next = second.next.next;

        return dummy.next;
    }
}

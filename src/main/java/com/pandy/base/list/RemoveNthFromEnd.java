package com.pandy.base.list;

import com.pandy.common.ListNode;
import com.pandy.common.TreeNode;

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

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}

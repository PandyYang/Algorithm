package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Pandy
 * @Date 2021/7/31 14:29
 * 使用set存储所有的节点 一直顺着链表向下查找
 * 如果查找到相同的元素 则证明有环
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

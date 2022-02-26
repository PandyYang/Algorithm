package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/1/14
 * 找到两个单链表相交的起始节点
 **/
public class FirstCommonNode {
    public ListNode first(ListNode pHead1, ListNode phead2) {

        Set<ListNode> nodels = new HashSet<>();

        while (pHead1 != null) {
            nodels.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (phead2 != null) {
            if (nodels.contains(phead2)) {
                return phead2;
            }
            phead2 = phead2.next;
        }
        return null;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/1/14
 * 找到两个单链表相交的起始节点
 *
 * 将链表1和链表2都加入到set中，判断是否包含，则可以找出相交链表
 **/
public class FirstCommonNode {
    public ListNode first(ListNode pHead1, ListNode phead2) {

        Set<ListNode> listNodes = new HashSet<>();

        while (pHead1 != null) {
            listNodes.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (phead2 != null) {
            if (listNodes.contains(phead2)) {
                return phead2;
            }
            phead2 = phead2.next;
        }
        return null;
    }
}

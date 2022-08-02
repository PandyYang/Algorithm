package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 环形链表的入口
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodes = new HashSet<>();
        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (listNodes.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }
        return null;
    }
}

package com.pandy.offer;

import com.pandy.common.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // 计算链表长度差
        int diff = Math.abs(lenA - lenB);

        // 让较长链表的指针先移动 diff 步
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        // 同时移动两个指针，直到它们指向相同的节点
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // 返回第一个重合节点，如果不存在，则返回 null
        return headA;
    }

    // 辅助函数，用于计算链表的长度
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

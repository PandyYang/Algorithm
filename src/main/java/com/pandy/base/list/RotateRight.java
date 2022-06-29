package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 6/6/2022
 * <p>
 * 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int count = 1;
        ListNode tmp = head;

        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }

        // k为0的时候 不需要旋转
        k %= count;
        if (k == 0) return head;

        // 首尾相连
        tmp.next = head;
        // 找到倒数第k+1个节点
        for (int i = 0; i < count - k; i++) {
            tmp = tmp.next;
        }

        ListNode newHead = tmp.next;

        // 避免死循环
        tmp.next = null;
        return newHead;
    }
}


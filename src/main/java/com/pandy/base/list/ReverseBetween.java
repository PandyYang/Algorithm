package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 13/6/2022
 *
 * 从m到n的区间内反转链表
 */
public class ReverseBetween {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        // 表头
        ListNode dummy = new ListNode(-1);

        // 表头连接入链表
        dummy.next = head;

        // 前序节点
        ListNode preStart = dummy;

        // 当前节点
        ListNode start = head;

        // 找到m
        for(int i =1; i < m; i++) {
            preStart = start;
            start = start.next;
        }

        // 从m反转到n
        for(int i = m; i < n; i++) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }

        return dummy.next;

    }
}

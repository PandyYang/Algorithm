package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 27/12/2021
 *
 * 删除节点分为三种情况"
 * 头结点
 * 尾结点
 * 中间节点
 */
public class DeleteNode {
    public void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null) return;
        if (head == deListNode) head = null;
        else{
            // 最后一个节点
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                // 一直走到倒数第二个节点
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                // 移除最后一个节点
                pointListNode.next = null;
            } else {
                // 非最后一个节点 指针后移
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        if(cur.val == val) return head.next;
        while(cur.val != val) {
            pre= cur;
            cur = cur.next;
        }

        pre.next = pre.next.next;
        return head;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 27/12/2021
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
}

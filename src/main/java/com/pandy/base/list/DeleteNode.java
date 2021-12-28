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
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                pointListNode.next = null;
            } else {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }
}

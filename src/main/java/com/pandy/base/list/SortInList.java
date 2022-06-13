package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 13/6/2022
 *
 * 链表的排序
 */
public class SortInList {
    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next == null) {
            return head;
        }

        ListNode move = head;
        while(move.next != null) {
            ListNode temp = move.next;
            while(temp != null) {
                if(temp.val < move.val) {
                    int val = temp.val;
                    temp.val = move.val;
                    move.val = val;
                }
                temp = temp.next;
            }
            move = move.next;
        }
        return head;
    }
}

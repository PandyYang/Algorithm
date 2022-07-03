package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 输出链表倒数第k个节点
 **/
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

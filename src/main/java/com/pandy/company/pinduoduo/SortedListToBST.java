package com.pandy.company.pinduoduo;

import com.pandy.common.ListNode;
import com.pandy.common.TreeNode;

/**
 * 链表转二叉搜索树
 */

class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        else if (head.next == null) return new TreeNode(head.val);

        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;

        //找到链表的中点p
        while (q != null && q.next != null) {
            pre = pre.next;
            p = pre.next;
            q = q.next.next;
        }

        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}

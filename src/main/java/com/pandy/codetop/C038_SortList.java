package com.pandy.codetop;

import com.pandy.common.ListNode;

public class C038_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;

        // 使用快慢指针寻找中点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割为两半
        pre.next = null;

        // 递归进行左右排序 递归将问题分解为很小 一个个 然后去排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 合并两个有序的链表
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 处理剩余的元素
        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // 创建链表 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        C038_SortList solution = new C038_SortList();
        ListNode sortedHead = solution.sortList(head);

        // 打印排序后的链表
        ListNode current = sortedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}

package com.pandy.codetop;

import com.pandy.common.ListNode;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // 每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (cur != null) {
            ListNode temp = cur.next; // 用于后移的节点
            cur.next = pre; // 当前节点指向前端的界面
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode node = ReverseList.reverseList(node0);
        System.out.println("node = " + node);
    }
}

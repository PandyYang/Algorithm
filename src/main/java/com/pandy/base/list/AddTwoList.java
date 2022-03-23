package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 28/12/2021
 */
public class AddTwoList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 临时节点
        ListNode dummyHead =new ListNode(0);

        ListNode p = l1, q = l2, curr = dummyHead;

        // 进位
        int carry = 0;

        while (p != null || q != null) {

            // 链表依次的值
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            // 当前总值  进位 + 当前值
            int sum = carry + x + y;

            // 计算进位
            carry = sum / 10;

            // 链表节点构造
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // 链表指针后移
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) curr.next = new ListNode(carry);

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = addTwoNumbers(l1, l4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

package com.pandy.company.pdd;

import com.pandy.common.ListNode;

import java.util.Stack;

/**
 * @author Pandy
 * @date 28/12/2021
 */
public class AddTwoList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return dummyHead.next;
    }

    // 正序
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }


        ListNode temp = null;
        int isCarry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || isCarry > 0) {
            int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + isCarry;
            // 余数
            ListNode n = new ListNode(sum % 10);
            // 进位
            isCarry = sum / 10;
            // 余数加入链表
            n.next = temp;
            // 逆序构建链表
            temp = n;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(9);

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
//        ListNode listNode = addTwoNumbers(l1, l4);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//
//        ListNode listNode2 = addTwoNumbers(l1, l4);
//        while (listNode2 != null) {
//            System.out.println(listNode2.val);
//            listNode2 = listNode2.next;
//        }

        ListNode listNode3 = addTwoNumbers3(l1, l4);
        while (listNode3 != null) {
            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.Stack;

/**
 * @Author Pandy
 * @Date 2021/7/31 13:19
 */
public class ReverseList {

    /**
     * 刚开始1指向2
     * node1.next = node2
     * 2此时反转需要指向1
     * node2.next = node1
     * 也就等于
     * node1.next.next = node1
     * 以此实现反转
     * @param head
     * @return
     */
    private ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * pre 用于保存前一个变量
     * curr
     * nxt 防止后面的链断掉
     * 详情查看
     * https://segmentfault.com/a/1190000037518253
     * @param head
     * @return
     */
    private ListNode reverseList3(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            // 反转
            curr.next = prev;
            // 向前移动
            prev = curr;
            // 向前移动
            curr = next;
        }
        return prev;
    }

    public void reverseList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode currentNode = head;
        Stack<ListNode> stack = new Stack<>();

        while (currentNode != null) {
            stack.push(currentNode);
            ListNode tempNode = currentNode.next;
            currentNode.next = null;
            currentNode = tempNode;
        }

        head = stack.pop();
        currentNode = head;

        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
    }
}

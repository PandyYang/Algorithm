package com.pandy.huawei.shousi;

import com.pandy.common.ListNode;

import java.util.Stack;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        // 初始化一个链表用于存放结果
        ListNode ret = new ListNode(0);

        // 为新链表定义一个指针，防止后续操作改变链表的头节点
        ListNode dummy = ret;

        while (true) {
            int count = 0;

            // 定义指针操作原有链表
            ListNode tmp = head;
            // 每k个入栈
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }

            // 不足k 说明完了 直接剩余节点插入末尾结束
            if (count != k) {
                dummy.next = head;
                break;
            }

            // 出栈翻转
            while (!stack.isEmpty()) {
                dummy.next = stack.pop();
                dummy = dummy.next;
            }

            // 重置下次操作的初始节点
            dummy.next = tmp;
            head = tmp;
        }
        return ret.next;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/4/21
 * <p>
 * K个一组反转链表
 * <p>
 * 需要把链表节点按照k个一组分组，所以可以使用一个指针head依次指向每组的头结点。这个
 * 指针每次向前移动k步，直至链表结尾。对于每个分组，我们先判断它的长度是否大于等于k，
 * 若是，翻转，否则不翻转。
 * <p>
 * 翻转一部分链表，出了翻转之外，还要将子链表的头部和上一个相连，以及尾部与下一个相连。
 * <p>
 * 因此不但需要子链表的头部head，还需要head的上一个节点pre，以便翻转完后把子链表再接回pre。
 * <p>
 * 但是对于第一个子链表，它的头结点head前面是没有节点pre的。构建一个节点，作为边界条件。
 **/
public class KReverseList {
    public ListNode reverseKGroup(ListNode head, int k) {

        // 构建虚拟节点 用于前驱的边界条件
        ListNode hair = new ListNode(0);

        hair.next = head;

        ListNode pre = hair;

        while (head != null) {

            // 模拟出尾结点 hair pre tail在同一位置
            ListNode tail = pre;
            // 查看剩余部分长度是不是大于等于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    // 不足k说明翻转完了 直接返回
                    return hair.next;
                }
            }

            // 下一个的开头
            ListNode nex = tail.next;

            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];

            // 将子链表放回原链表
            pre.next = head;
            tail.next = nex;


            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;

        while (prev != tail) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();

        // 初始化一个链表用于存放结果
        ListNode ret = new ListNode(0);

        // 为新链表定义一个指针，防止后续操作改变链表的头节点
        ListNode p = ret;

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
                p.next = head;
                break;
            }

            // 出栈翻转
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }

            // 重置下次操作的初始节点
            p.next = tmp;
            head = tmp;
        }
        return ret.next;
    }
}

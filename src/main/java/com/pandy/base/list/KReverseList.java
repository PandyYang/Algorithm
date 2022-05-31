package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/4/21
 *
 * K个一组反转链表
 *
 * 需要把链表节点按照k个一组分组，所以可以使用一个指针head依次指向每组的头结点。这个
 * 指针每次向前移动k步，直至链表结尾。对于每个分组，我们先判断它的长度是否大于等于k，
 * 若是，翻转，否则不翻转。
 *
 * 翻转一部分链表，出了翻转之外，还要将子链表的头部和上一个相连，以及尾部与下一个相连。
 *
 * 因此不但需要子链表的头部head，还需要head的上一个节点pre，以便翻转完后把子链表再接回pre。
 *
 * 但是对于第一个子链表，它的头结点head前面是没有节点pre的。构建一个节点，作为边界条件。
 *
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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        KReverseList list = new KReverseList();
        ListNode[] reverse = list.myReverse(listNode1, listNode4);
        for (ListNode listNode : reverse) {
            System.out.println(listNode.val);
        }
    }
}

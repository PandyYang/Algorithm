package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *
 *     /**
 *      * 参考：Sort List——经典（链表中的归并排序） https://www.cnblogs.com/qiaozhoulin/p/4585401.html
 *      *
 *      * 归并排序法：在动手之前一直觉得空间复杂度为常量不太可能，因为原来使用归并时，都是 O(N)的，
 *      * 需要复制出相等的空间来进行赋值归并。对于链表，实际上是可以实现常数空间占用的（链表的归并
 *      * 排序不需要额外的空间）。利用归并的思想，递归地将当前链表分为两段，然后merge，分两段的方
 *      * 法是使用 fast-slow 法，用两个指针，一个每次走两步，一个走一步，知道快的走到了末尾，然后
 *      * 慢的所在位置就是中间位置，这样就分成了两段。merge时，把两段头部节点值比较，用一个 p 指向
 *      * 较小的，且记录第一个节点，然后 两段的头一步一步向后走，p也一直向后走，总是指向较小节点，
 *      * 直至其中一个头为NULL，处理剩下的元素。最后返回记录的头即可。
 *      *
 *      * 主要考察3个知识点，
 *      * 知识点1：归并排序的整体思想
 *      * 知识点2：找到一个链表的中间节点的方法
 *      * 知识点3：合并两个已排好序的链表为一个新的有序链表
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    private ListNode mergeSort(ListNode head) {
        // 如果没有结点/只有一个结点，无需排序，直接返回
        if (head == null || head.next == null) return head;
        // 快慢指针找出中位点
        ListNode slowp = head, fastp = head.next.next, l, r;

        while (fastp != null && fastp.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }
        // 对右半部分进行归并排序
        r = mergeSort(slowp.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowp.next = null;
        // 对左半部分进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    // 合并链表
    private ListNode mergeList(ListNode l, ListNode r) {
        // 临时头节点
        ListNode tmpHead = new ListNode(-1);
        ListNode p = tmpHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        SortList insertionSortList = new SortList();
        ListNode listNode = insertionSortList.sortList(l1);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/6/28
 *
 * 对链表进行插入排序
 *
 * 想要排序块，就要尽可能少的做比较
 * 需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
 * 需要另外一个指针pre,每次从表头循环，这里用的是dummy表头指针。
 * 每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
 * 如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
 **/
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while (head != null && head.next != null) {
            // 找到大于 下一个 节点的值
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }

            //
            pre = dummy;

            // 每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
            while (pre.next.val < head.next.val){
                pre = pre.next;
            }

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode listNode = insertionSortList.insertionSortList(l1);
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}

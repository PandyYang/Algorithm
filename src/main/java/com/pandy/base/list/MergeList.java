package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/1/3
 * 合并两个有序的链表
 **/
public class MergeList {
    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.HashSet;

/**
 * 环形链表的入口
 * <p>
 * list存储扫描过的节点
 * 求下一个节点是否在链表中出现过
 */
public class EntryNodeOfLoop {
    public ListNode test(ListNode listNode) {
        if (listNode == null || listNode.next == null) return null;
        ListNode l1 = listNode;
        ListNode l2 = listNode;
        // 避免走两步时 空指针
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                l2 = listNode;
                while (l1 != l2) {
                    l1 = l1.next;
                    l2 = l2.next;
                }
                return l1;
            }
        }
        return null;
    }

    /**
     * 将所有扫描过的节点都放在set
     * 看是否下一个节点已经在set出现过
     *
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            }
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}

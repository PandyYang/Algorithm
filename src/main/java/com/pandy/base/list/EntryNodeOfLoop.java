package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
        // 避免走两步时空指针
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
     * 将所有扫描过的节点都放在list列表中
     * 看是否下一个节点已经在list列表中出现过
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode targetNode = new ListNode(3);

        if (pHead == null || pHead.next == null) return null;

        List<ListNode> nodesList = new ArrayList<>();
        nodesList.add(pHead);
        targetNode = pHead.next;
        while (!nodesList.contains(targetNode)) {
            nodesList.add(targetNode);
            targetNode = targetNode.next;
        }
        return targetNode;
    }
}

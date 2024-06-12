package com.pandy.huawei.three;

import com.pandy.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) continue;
            queue.add(list);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.add(poll);
            }
        }
        return dummy.next;
    }
}

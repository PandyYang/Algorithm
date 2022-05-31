package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author Pandy
 * @date 22/4/2022
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode list : lists) {
            if (list == null) continue;
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            curr.next = poll;
            curr = curr.next;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return dummyHead.next;
    }

}

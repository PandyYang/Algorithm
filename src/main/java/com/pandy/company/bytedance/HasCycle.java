package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/7/1
 **/
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 删除链表中的重复元素
 * <p>
 * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
 * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
 * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
 * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
 **/
public class DeleteDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 移动节点
        head.next = deleteDuplicates(head.next);

        // 判断重复
        if (head.val == head.next.val) head = head.next;

        return head;
    }
}

package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pandy
 * @date 20/12/2021
 *
 * 输入一个链表，从尾到头打印链表每个节点的值
 *
 * 借助栈实现，或者使用递归的思想
 */
public class PrintListFromTailToHead {

    private static List<Integer> print(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return null;

        Stack<ListNode> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }

        for (ListNode node : stack) {
            list.add(node.val);
        }
        return list;
    }
}

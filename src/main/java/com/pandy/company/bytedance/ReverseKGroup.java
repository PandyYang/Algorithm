package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/2
 *
 * k个一组翻转链表
 *
 * 想了2个多小时，才搞清楚大佬所说的好理解的思路…实际上就是在每个组内，
 * 把cur后面的一个数提到最前面，拿12345， k=3举例，第一组就是123，1为cur，
 * 且在2次循环中，cur指向从未变化，第一轮把1后面的2提到最前面，变成213，
 * 第二轮把1后面的3，提到头部，变成321 然后以这样的思想去理解内循环就很方便了……
 **/
public class ReverseKGroup {

    public static ListNode reverKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        // 初始化一个链表用于存放结果

        ListNode dummy = new ListNode(0);
        // 为新链表定义一个指针，防止后续操作改变链表的头节点
        ListNode p = dummy;

        while (true) {
            int count = 0;

            // 定义指针操作原有链表
            ListNode tmp = head;
            // 每k个入栈
            while (tmp != null && count < k) {
                stack.push(tmp);
                tmp = tmp.next;
                count++;
            }

            // 不足k 说明完了 直接剩余节点插入末尾结束
            if (count != k) {
                p.next = head;
                break;
            }

            // 出栈翻转
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }

            // 重置下次操作的初始节点
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = ReverseKGroup.reverKGroup(listNode1, 3);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode1.next;
        }
    }


    public ListNode revereKGroup2(ListNode head, int k) {
        int length = 0;
        ListNode checkPoint = head;

        while(checkPoint != null) {
            length ++;
            checkPoint = checkPoint.next;
        }

        //固定虚拟头结点
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode curr = head;
        ListNode next;

        for(int i=0; i < length / k ; i++) {
            for(int j=0; j < k - 1; j++) {
                next = curr.next;
                //当前节点会携带之前的子节点指向第3个节点
                curr.next = next.next;
                //被挪动指向第1个节点,pre.next指的就是首节点
                next.next = pre.next;
                //固定虚拟节点指向挪动的节点，完成两个节点交换并且固定节点指向被挪动的节点
                pre.next = next;
            }
            //挪动执行区间
            pre = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}

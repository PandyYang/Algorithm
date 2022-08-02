package com.pandy.common;

public class ListNode {
    public Integer val;
    public ListNode next = null;

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }
}

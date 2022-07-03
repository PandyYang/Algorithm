package com.pandy.common;

/**
 * @author: Pandy
 * @create: 2022/7/3
 **/
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

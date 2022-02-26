package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * 非空数组，除了某个元素只出现一次以外，其余每个元素均出现两次，找出那个只出现一次的元素。'
 * 使用hashmap或者异或运算符
 **/
public class SingleNum {
    public int single(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a = num ^ a;
        }
        return a;
    }
}

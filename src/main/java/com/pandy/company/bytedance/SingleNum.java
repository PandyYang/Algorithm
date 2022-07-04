package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 只出现一次的数字
 *
 **/
public class SingleNum {
    public static void main(String[] args) {
        SingleNum singleNum = new SingleNum();
        int i = singleNum.singleNum(new int[]{2, 2, 1, 3, 4, 1, 3});
        System.out.println("i = " + i);
    }

    public int singleNum(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

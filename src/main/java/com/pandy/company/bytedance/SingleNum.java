package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 **/
public class SingleNum {
    public int singleNum(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        SingleNum singleNum = new SingleNum();
        int i = singleNum.singleNum(new int[]{2, 2, 1, 3, 4, 1, 3});
        System.out.println("i = " + i);
    }
}

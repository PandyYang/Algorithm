package com.pandy.codetop;

/**
 * 主要是看有无增益。
 * 所谓增益就是，检查每个元素是否为正数。否则的话，将其置为当前值。
 * 注意增益是对于sum而言的。
 */
public class C007_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 有增益 则可以继续增加元素 注意是sum > 0 不是nums[i]!!!
            if (sum > 0) {
                sum += nums[i];
            } else {
                // 没有增益 则将其置为当前值
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

}

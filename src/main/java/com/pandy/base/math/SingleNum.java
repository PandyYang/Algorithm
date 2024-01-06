package com.pandy.base.math;

public class SingleNum {
    // 对于数组中的每个数字，对每一位进行统计，计算出在这一位上 1 出现的总次数。由于除了一个数字出现了 m 次外，
    // 其他的数字都出现了 n 次，如果我们将这一位上 1 出现的次数对 n 取模，得到的结果要么是 0（表示除了出现 m 次的数字，
    // 其他所有数字在这一位上的 1 的总次数能被 n 整除），要么是出现 m 次的那个数字在这一位上的 1 的数量。
    // 我们对所有位都这样操作，就可以恢复出只出现 m 次的那个数字。
    public int singleNumber(int[] nums, int m, int n) {
        int result = 0;

        // 对每个位进行处理
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                // 统计第 i 位上 1 的总次数
                if ((num >> i & 1) == 1) {
                    sum++;
                }
            }

            // 对 n 取模，判断这一位是否属于那个唯一的数字
            if (sum % n != 0) {
                // 把第 i 位设置为 1
                result |= (1 << i);
            }
        }

        return result;
    }

}

package com.pandy.base.heap;

/**
 * @author Pandy
 * @date 24/3/2022
 * <p>
 *
 * <p>
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
 * 而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 */
public class GetKthMagicNumber {

    public static int getKthMagicNumber(int k) {
        int[] result = new int[k];

        // 最小符合的数字
        result[0] = 1;

        // 追踪因子
        int p0 = 0, p1 = 0, p2 = 0;

        // 循环生成k个魔法数字
        for (int i = 1; i < k; i++) {

            int v1 = result[p0] * 3;
            int v2 = result[p1] * 5;
            int v3 = result[p2] * 7;

            // 然后选择这三个结果中的最小值作为当前位置的魔法数字。这确保了魔法数字是按照从小到大的顺序被填充的。
            int min = Math.min(v1, v2);
            min = Math.min(min, v3);
            result[i] = min;

            // 确定不会重复
            if (min == v1) {
                p0++;
            }
            if (min == v2) {
                p1++;
            }
            if (min == v3) {
                p2++;
            }
        }
        return result[k - 1];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(getKthMagicNumber(i));
        }
    }
}

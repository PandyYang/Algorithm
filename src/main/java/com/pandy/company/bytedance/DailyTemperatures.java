package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/6/30
 *
 * 温度变化
 *
 * <p>
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
 * 其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();

        int[] ints = dailyTemperatures.dailyTemperature(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    public int[] dailyTemperature(int[] T) {
        int[] res = new int[T.length];
        // 总之就是求当前元素 到下一个比它大的元素的距离
        P:
        for (int i = 0; i < T.length; i++) {
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    // 使用位置标记 只取第一个大的时候
                    continue P;
                }
            }
        }
        return res;
    }
}

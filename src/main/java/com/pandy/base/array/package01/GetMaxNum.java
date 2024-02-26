package com.pandy.base.array.package01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author: Pandy
 * @create: 2022/6/11
 * <p>
 * 能被K整除最多次的整数一共有多少个
 * 比如在0 - 10的区间内计算3能被整除最多的
 * 3 6 9
 * 能被整除的次数是 1 1 2
 * 能被整除的最多的次数只有9 为 2次，所以是1个
 **/
public class GetMaxNum {

    public static void main(String[] args) {
        int max = getMax(3, 10);
        System.out.println("max = " + max);
    }

    public static int getMax(int i, int j) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int m = 2; m <= j; m++) {
            if (m % i == 0) {
                int can = can(i, m);
                System.out.println(m + " " + can);
                list.add(can);
            }
        }

        // 此处计算list中的最大数出现了多少次
        Integer max = Collections.max(list);
        int sum = 0;
        for (Integer integer : list) {
            if (Objects.equals(integer, max)) sum++;
        }
        System.out.println(sum);
        return sum;
    }

    // 计算j可以被i整除的次数
    public static int can(int i, int j) {
        int sum = 0;
        while (j / i > 1 || j % i == 0) {
            sum++;
            j = j / i;
        }
        return sum;
    }
}

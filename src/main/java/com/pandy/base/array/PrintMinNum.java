package com.pandy.base.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author: Pandy
 * @create: 2022/1/14
 **/
public class PrintMinNum {
    public static String print(int[] numbers) {
        List<String> nums = new ArrayList<>();
        for (int number : numbers) {
            nums.add(String.valueOf(number));
        }

        nums.sort(Comparator.comparing(s -> s, (o1, o2) -> (o1 + o2).compareTo(o2 + o1)));

        StringJoiner joiner = new StringJoiner("");
        nums.forEach(joiner::add);
        return joiner.toString();
    }

    public static void main(String[] args) {
        String print = print(new int[]{3, 32, 321});
        System.out.println("print = " + print);
    }
}

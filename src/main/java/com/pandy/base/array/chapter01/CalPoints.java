package com.pandy.base.array.chapter01;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author: Pandy
 * @create: 2022/3/26
 **/
public class CalPoints {

    public static int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= ops.length-1; i++) {
                String cur = ops[i];
                switch (cur) {
                    case "+":
                        list.add(list.get(list.size()-1) + list.get(list.size() -2));
                        break;
                    case "D":
                        list.add(list.get(list.size()-1) * 2);
                        break;
                    case "C":
                        list.remove(list.size() - 1);
                        break;
                    default:
                        list.add(Integer.parseInt(cur));
                        break;
                }

        }
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"5","2","C","D","+"};
        int i = calPoints(arr);
        System.out.println("i = " + i);
    }

}

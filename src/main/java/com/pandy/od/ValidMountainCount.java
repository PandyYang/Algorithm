package com.pandy.od;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidMountainCount {


    public static void main(String[] args) {
        //输入,此处仅为测试，考试时为leetcode模式
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        String[] tmp2 = input_str.split(",");
        int[] nums = new int[tmp2.length];
        for (int i = 0; i < tmp2.length; i++) {
            nums[i] = Integer.parseInt(tmp2[i]);
        }
        System.out.println(validMountainCount(nums));
    }

    public static int validMountainCount(int[] arr) {
        int result = 0;
        int index = 0;
        int arrLen = arr.length;

        while (true) {
            // 边界条件
            if (index >= arrLen) {
                return result;
            } else {
                //左边界
                if (index == 0) {
                    // 最左边是一个山峰
                    if (arr[index] > arr[index + 1]) {
                        result += 1;
                    }
                } else if (index == arrLen - 1) {
                    if (arr[index - 1] < arr[index]) {
                        result += 1;
                    }
                } else {
                    if (arr[index - 1] < arr[index] && arr[index + 1] < arr[index]) {
                        result += 1;
                    }
                }
            }
            // 每次都向右遍历
            index += 1;
        }
    }
}


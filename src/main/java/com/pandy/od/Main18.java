package com.pandy.od;

import java.util.Scanner;

public class Main18 {
    public static void main(String[] args) {
        // 创建一个Scanner对象，用于读取用户输入
        Scanner in = new Scanner(System.in);
        // 读取用户输入的字符串
        String input = in.nextLine();
        // 将输入的字符串转换为字符数组
        char[] chrs = input.toCharArray();
        // 获取字符串的长度
        int len = chrs.length;
        // 初始化'o'字符的计数器
        int num = 0;
        // 遍历字符数组，统计'o'字符的数量
        for (char chr : chrs) {
            if (chr == 'o') {
                num += 1;
            }
        }
        // 如果'o'字符出现的次数是偶数，则输出字符串的长度
        if (num %2 ==0){
            System.out.println(len);
        } else{
        // 如果'o'字符出现的次数是奇数，则输出字符串长度减1
            System.out.println(len - 1);
        }
    }
}

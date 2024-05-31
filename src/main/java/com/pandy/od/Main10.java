package com.pandy.od;

import java.util.Scanner;
import java.util.HashMap;

public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        // 总的财富数
        int[] money = new int[count+1];

        for (int i = 1; i <= count; ++i) {
            money[i] = in.nextInt();
        }

        // 使用map保存家庭成员之间的关系 计算财富数
        //family relationship
        HashMap<Integer, Integer> relations = new HashMap<>();

        // 每个家庭对应的财富
        for (int i = 1; i <= count; ++i) {
            relations.put(i, money[i]);
        }

        // 计算所有父节点的钱
        for (int i = 1; i < count; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            relations.put(a, money[b]+relations.get(a));
        }

        int max_val= 0;
        for (int i = 1; i <= count; ++i){
            max_val = Math.max(max_val, relations.get(i) ) ;
        }
        System.out.println(max_val);
    }

}

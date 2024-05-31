package com.pandy.huawei.simulation._01;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class HJ94 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 候选人的人数
        int corNum = scanner.nextInt();
        scanner.nextLine();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String[] corNames = scanner.nextLine().split(" ");
        for (String corName : corNames) {
            map.put(corName, 0);
        }
        int voteNum = scanner.nextInt();
        scanner.nextLine();
//        for (int i = 0; i < voteNum - 1; i++) {
//
//        }

        Set<String> corName = map.keySet();
        int valid = 0;
        String[] votes = scanner.nextLine().split(" ");
        for (String vote : votes) {
            if (corName.contains(vote)) {
                Integer vNum = map.getOrDefault(vote, 0);
                map.put(vote, vNum+1);
            } else {
                valid ++;
            }
        }

        for (String s : map.keySet()) {
            Integer num = map.get(s);
            System.out.println(s +" : " + num);
        }

        System.out.println("Invalid : " + valid);
    }
}

package com.pandy.od;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 开源的数目
        int n = in.nextInt();

        // 权重
        int[] weights = new int[5];
        for(int i = 0; i < 5; i++){
            weights[i] = in.nextInt();
        }

        List<Map<String, Object>> projects = new ArrayList<>();

        //
        for(int i = 0; i < n; i++){
            int[] pro = new int[5];
            // 对应的项目和统计维度
            String[] strs = in.nextLine().split(" ");
            // 项目名称
            String name = strs[0];

            pro[0] = Integer.parseInt(strs[1]);
            pro[1] = Integer.parseInt(strs[2]);
            pro[2] = Integer.parseInt(strs[3]);
            pro[3] = Integer.parseInt(strs[4]);
            pro[4] = Integer.parseInt(strs[5]);
            // 热度计算
            int hotValue = calcuateHotvalue(weights, pro);

            // 对应的项目和热度 进行对比
            Map<String,Object> map = new HashMap<>();
            map.put("name",name);
            map.put("hotvalue",hotValue);
            projects.add(map);
        }
        projects.sort((p1, p2) -> {
            // 根据热度
            if ((int) p1.get("hotvalue") != (int) p2.get("hotvalue")) {
                return Integer.compare((int) p2.get("hotvalue"), (int) p1.get("hotvalue"));
            } else {
                // 根据名称
                return ((String) p1.get("name")).toLowerCase().compareTo(((String) p2.get("name")).toLowerCase());
            }
        });
        // 直接输出
        for(Map<String,Object> project: projects){
            System.out.println(project.get("name"));
        }
    }
    public static int calcuateHotvalue(int[] weights, int[] pro){
        int res = 0;
        for(int i = 0; i < weights.length; i++){
            res += weights[i] * pro[i];
        }
        return res;
    }

}
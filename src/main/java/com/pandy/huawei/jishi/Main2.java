package com.pandy.huawei.jishi;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * 为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 * 现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
 * 现在给定一组确诊人员编号(X1,X2,X3,..Xn)在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的数。
 * (注意：确诊病例自身不需要再做核酸检测)需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有
 * 人。
 * 例如：A是确诊病例，A和B有接触、B和C有接触C和D有接触，D和E有接触。那么B、C、D、E都是需要进行核酸检测的人
 * 输入描述
 * 第一行为总人数N
 * 第二行为确证病例人员编号(确证病例人员数量<N),用逗号隔开
 * 接下来N行，每一行有N个数字，用逗号隔开，其中第行的第j个数字表名编号是否与编号接触过。0表示没有接触，1表示有接触
 * 备注：
 * 人员编号从0开始
 * 0<N<100 0<N<1000<N<100
 * 输出描述
 * 输出需要做核酸检测的人数
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 总人数
        int N = Integer.parseInt(scanner.nextLine());
        // 确诊病例人员编号
        String[] confirms = scanner.nextLine().split(",");

        // 创建接触矩阵
        boolean[][] techie = new boolean[N][N];
        // 创建访问记录数组
        boolean[] visited = new boolean[N];

        // 构建接触矩阵
        for (int i = 0; i < N; i++) {
            String[] row = scanner.nextLine().split(",");
            for (int j = 0; j < N; j++) {
                techie[i][j] = Objects.equals(row[j], "1");
            }
        }

        // 对每个病人进行深度优先搜索
        for (String person : confirms) {
            int i = Integer.parseInt(person);
            dfs(techie, visited, i);
        }

        // 需要进行核酸检测的人数
        int count = 0;
        // 遍历访问记录数组 统计需要检测的人数
        for (int i = 0; i < N; i++) {
            // 如果该人员曾经被访问过
            if (visited[i]){
                // 检查该人员是否为确诊病例
                boolean contains = Arrays.asList(confirms).contains(String.valueOf(i));
                // 如果这个人不是确诊病例，但通过传播链条被访问过，那么他们需要进行核酸检测，因此计数器 count 加一。
                if (!contains){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(boolean[][] jiechu, boolean[] visited,int index) {
        visited[index]= true;
        for (int i = 0; i < jiechu.length; i++) {
            // 当前节点与其他节点有接触且节点未被访问过
            if (jiechu[index][i] && !visited[i]) {
                // 递归访问该节点
                dfs(jiechu, visited, i);
            }
        }
    }
}

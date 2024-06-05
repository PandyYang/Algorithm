package com.pandy.huawei.jishi;

import java.util.Scanner;

/**
 * 小华按照地图去寻宝，地图上被划分成m行和n列的方格，横纵坐标范围分别是[0,n-1]和[0, m-1]。
 * 在横坐标和纵坐标的数之和不大于K的方格中存在黄金(每个方格中仅存在一克黄金),
 * 但横坐标和纵坐标数位之和大于K的方格存在危险不可进入。小华从入口0进入，任何时候只能向左，右，上，下四个方向移动
 * 格。
 * 请问小华最多能获得多少克黄金?
 */
public class Main {
    private static int m, n, k;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[m][n];
        System.out.println(dfs(0,0));
    }

    private static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || sumOfDigits(x) + sumOfDigits(y) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
    }

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

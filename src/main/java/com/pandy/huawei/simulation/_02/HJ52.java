package com.pandy.huawei.simulation._02;

import java.util.Scanner;

public class HJ52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(editDistance(str1, str2));
    }

    public static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符相等，则不需要编辑，dp[i][j] = dp[i-1][j-1]
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                // 当添加一个字符时，dp[i][j] = dp[i][j-1] + 1
                // 当删除一个字符时，dp[i][j] = dp[i-1][j] + 1
                // 当替换一个字符时（如果当前字符不相等），dp[i][j] = dp[i-1][j-1] + 1
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}

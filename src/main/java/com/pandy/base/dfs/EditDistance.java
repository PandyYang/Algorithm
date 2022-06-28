package com.pandy.base.dfs;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/28
 **/
public class EditDistance {

    public int editDistance(String str1, String str2) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(str1, len1, str2, len2, dp);
    }

    public int dfs(String str1, int index1, String str2, int index2, int[][] dp) {
        if (dp[index1][index2] != -1) return dp[index1][index2];
        //如果str1到结尾了 那就是str2全删就行
        if (index1 == 0) return dp[index1][index2] = index2;

        if (index2 == 0) return dp[index1][index2] = index1;

        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1))
            return dp[index1][index2] = dfs(str1, index1 - 1, str2, index2 - 1, dp);
        //这里都用str1 i,j不相等替换f(i-1,j-1)  删除i f(i-1,j) 插入i f(i,j-1)
        return dp[index1][index2] = Math.min(dfs(str1, index1 - 1, str2, index2 - 1, dp),
                Math.min(dfs(str1, index1, str2, index2 - 1, dp), dfs(str1, index1 - 1, str2, index2, dp))) + 1;
    }

    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        int i = distance.editDistance("abc", "abcd");
        System.out.println("i = " + i);
    }
}

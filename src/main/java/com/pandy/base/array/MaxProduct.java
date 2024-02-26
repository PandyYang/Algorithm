package com.pandy.base.array;

public class MaxProduct {

    public int maxProduct(String[] words) {
        // 记录每个子数组的每个元素出现的位置 注意默认所有位置是false
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    // 这是一个暴力遍历子数组
                    // 每个子数组的每个位置 相与 查看是否存在相同的元素
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                // k为26 说明没有重复的。
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}

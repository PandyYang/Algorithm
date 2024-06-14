package com.pandy.huawei.three;

import java.util.*;

/**
 * 如果入参可能重复 用set接收
 * 元素不能重用 用visited标识
 * 如果长度不一致 包含各种子集 用index
 *
 * 某店铺将用于组成套餐的商品记作字符串 goods，其中 goods[i] 表示对应商品。请返回该套餐内所含商品的 全部排列方式 。
 * 返回结果 无顺序要求，但不能含有重复的元素。
 */

public class L157_GoodsOrder {
    public String[] goodsOrder(String goods) {
        char[] chars = goods.toCharArray();
        Arrays.sort(chars);
        String s = String.valueOf(chars);
        HashSet<String> res = new HashSet<>();
        dfs(s, res, new StringBuilder(), new boolean[s.length()], 0);
        return res.toArray(new String[0]);
    }

    private void dfs(String s, HashSet<String> res, StringBuilder temp, boolean[] visited, int index) {
//        if (temp.length() == s.length()) {
//            res.add(temp.toString());
//            return;
//        }

        if (temp.length() > 0) {
            res.add(temp.toString());
        }

        for (int i = index; i < s.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.append(s.charAt(i));
            dfs(s, res, temp, visited, i +1);
            temp.deleteCharAt(temp.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] strings = new L157_GoodsOrder().goodsOrder("abcd");
        String string = Arrays.toString(Arrays.stream(strings).toArray());
        System.out.println("string = " + string);
    }
}

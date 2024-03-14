package com.pandy.base.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * <p>
 * <p>
 * 分糖果
 * 有一定数量的糖果，每种类型的糖果可能有多个，一个人可以吃掉一半数量的糖果。你想让这个人尝试尽可能多种类型的糖果。
 * <p>
 * 根据题意，妹妹每种糖果至少要拿一颗1.
 * 1. 如果糖果种类数<=数组长度的一半，那么妹妹可以拿到所有种类的糖果。ans = 糖果种类数
 * 2. 如果糖果种类数>数组长度的一半，那么妹妹能拿到的所有糖果都互不相同。ans = candyType.length/2
 * 二者取小即可。
 **/
public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }

        return Math.min(set.size(), candyType.length / 2);
    }
}

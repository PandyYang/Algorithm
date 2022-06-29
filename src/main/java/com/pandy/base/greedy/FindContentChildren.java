package com.pandy.base.greedy;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * <p>
 * <p>
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
 * 都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * <p>
 * 其实可以理解为站在小朋友的角度，来了一块饼干就让一位胃口较小的小朋友看看它是否符合，要是符合，匹配数加一，
 * 要是不符合，这位小朋友只能等下一块，而ta之后的小朋友也是不符合这块的。
 * 直到所有的小朋友都领到饼干或者饼干已经没了为止
 **/
public class FindContentChildren {

    // 胃口和尺寸
    public int findContentChildren(int[] g, int[] s) {
        int children = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (children < g.length && cookie < s.length) {
            if (g[children] <= s[cookie]) {
                children++;
            }
            cookie++;
        }
        return children;
    }
}

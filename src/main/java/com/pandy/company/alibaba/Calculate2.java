package com.pandy.company.alibaba;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/4
 *
 * 只有加减括号
 *
 **/
public class Calculate2 {
    public int calculate(String s) {
        /*
        参考评论区第一的思路:
        a)用一个变量res维护当前正在算的区块的和
        即若当前位置是位于()内的,res就是()内的和;如果是()外的,就是当前位置左边的和
        b)同时用一个变量sign维护当前操作符的正负
        1.遇到数字时,向右计算出完整的数字并追加到当前区块的和res中
        2.遇到"+"或"-"时,将符号位记录在sign中
        3.遇到"("时,表明重新开始了一个区块,先记录之前区块的res和sign进栈,然后res置0,sign置1,开始重新计算新区块的值
        4.遇到")"时,标志着该区块结束,将当前()内区块的res*sign追加到栈顶保存的旧的res中
        由于计算到最后,所在区块必定是整个式子,因此直接返回res即可
        */
        int res = 0, sign = 1;
        // stack用来保存之前区块的和以及新区块的符号
        Stack<Integer> stack = new Stack<>();
        // 去除空格
        s = s.replaceAll(" ", "");
        // 若去除空格后再遍历,len要取去除后的值
        // 也可以遍历的时候直接忽略' '的情况,例如遇到' '就continue;抑或if里面判断时直接忽略掉' '的情形
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                // s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'来判断也可以
                // 1.遇到数字:向右计算完整数字并追加到res中
                // cur是当前完整数字
                int cur = c - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                // 追加到res中(别漏了符号)
                res += cur * sign;
            }else if(c == '+' || c == '-'){
                // 2.遇到操作符:更新sign
                sign = c == '+' ? 1 : -1;
            }else if(c == '(') {
                // 3.遇到'(':记录并重置res与sign
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else {
                // 4.遇到')':计算当前区块的和并追加到res
                // 这里的stack.pop() * res是当前区块 * 栈中保存的当前区块的符号:-(1+2)
                // 后面的stack.pop()是之前的res的值:当前区块外的值
                // 两者加上就是算上()后的总的区块的和
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Calculate2 calculate2 = new Calculate2();
        int calculate = calculate2.calculate("1 + (3-2)/1");
        System.out.println("calculate = " + calculate);
    }
}

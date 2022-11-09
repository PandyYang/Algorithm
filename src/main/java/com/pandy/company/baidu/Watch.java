package com.pandy.company.baidu;

/**
 * 12进制的表 任意一个时间点 时针和分针形成的角度。
 * 入参
 * 时 int接收
 * 分钟 int接收
 * 求角度，较小的那个角度
 */
public class Watch {
    public static void main(String[] args) {
        int h = 11;
        int m = 0;
        double q = (double) m / 5;
//        System.out.println(q);
        System.out.println(Math.min(Math.abs(q - h), 12 - Math.abs(q - h)) * 30);
    }
}

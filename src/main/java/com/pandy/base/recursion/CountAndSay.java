package com.pandy.base.recursion;

/**
 * @author: Pandy
 * @create: 2022/3/26
 **/
public class CountAndSay {

    public static String countAndSay(int n) {
        String str = "1";

        // 处理的轮数
        for (int i = 2; i <= n; i++) {

            StringBuilder builder = new StringBuilder();
            // 记录每一位的数字
            char pre = str.charAt(0);
            int  count = 1;

            // 每一位数字 还要进行拆分 和当前数字进行
            for (int j = 1; j < str.length(); j++) {

                // 拆分时
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println("s = " + s);
    }
}

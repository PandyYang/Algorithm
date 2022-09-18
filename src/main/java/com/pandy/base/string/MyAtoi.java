package com.pandy.base.string;

class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int i = myAtoi.myAtoi("-99999999000009");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        // 去掉前导
        while (idx < n && chars[idx] == ' ') {
            idx++;
        }
        // 是否全部为空格
        if (idx == n) return 0;
        // 判断正负号
        boolean negative = false;
        // 遇见减号要注意记录
        if (chars[idx] == '-') {
            negative = true;
            idx++;
            // 遇见加号直接略过
        } else if (chars[idx] == '+') {
            idx++;
            // 不是数字 也不是正负号 直接返回0
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }
        int ans = 0;

        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }
}

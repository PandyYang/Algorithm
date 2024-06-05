package com.pandy.huawei.shousi;

public class FindNthDigit {
    public static void main(String[] args) {
        int n = 11;  // 示例输入
        int result = findNthDigit(n);
        System.out.println(result);  // 输出: 0
    }

    public static int findNthDigit(int n) {
        long digitLength = 1;  // 当前数字范围的位数（个位、十位、百位等）
        long count = 9;        // 当前数字范围内的数字个数
        long start = 1;        // 当前数字范围内的第一个数字

        // 找到 n 所在的数字范围
        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // 确定具体的数字
        long num = start + (n - 1) / digitLength;

        // 确定数字中的特定位
        String numStr = Long.toString(num);
        return Character.getNumericValue(numStr.charAt((int)((n - 1) % digitLength)));
    }
}

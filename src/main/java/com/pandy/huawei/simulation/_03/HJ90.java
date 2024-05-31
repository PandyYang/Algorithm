package com.pandy.huawei.simulation._03;

import java.util.Objects;
import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        System.out.println(isValidIP(ip) ? "YES" : "NO");
        scanner.close();
    }

    private static boolean isValidIP(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false; // IP地址必须由四部分组成
        }
        for (String part : parts) {
            if (!isValidPart(part)) {
                return false; // 检查每部分是否合法
            }
        }
        return true;
    }

    private static boolean isValidPart(String part) {
        try {
            int number = Integer.parseInt(part);
            // 验证数字范围，并且检查没有前导零
            return number >= 0 && number <= 255 && part.equals(Integer.toString(number));
        } catch (NumberFormatException e) {
            return false; // 非法数字
        }
    }
}

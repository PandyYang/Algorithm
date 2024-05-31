package com.pandy.huawei.simulation._03;

import java.util.Scanner;

public class HJ87 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password.length() == 0) {
            System.out.println("Very_Weak");
        }
        int addition = 0;
        if ((fuhao(password)) > 0 && (ischar(password) == 20) && (num(password) > 0)) {
            addition += 5;
        } else if ((fuhao(password)) > 0 && (ischar(password) > 0) && (num(password) > 0)) {
            addition += 3;
        } else if ((ischar(password) > 0) && (num(password) > 0)) {
            addition += 2;
        }

        int res = len(password) + num(password) + ischar(password) + fuhao(password) + addition;
        if (res >= 90) {
            System.out.println("VERY_SECURE");
        } else if (res >= 80) {
            System.out.println("SECURE");
        } else if (res >= 70) {
            System.out.println("VERY_STRONG");
        } else if (res >= 60) {
            System.out.println("STRONG");
        } else if (res >= 50) {
            System.out.println("AVERAGE");
        } else if (res >= 25) {
            System.out.println("WEAK");
        } else if (res >= 0) {
            System.out.println("VERY_WEAK");
        }
    }

    static int len(String s) {
        if (s.length() <= 4) {
            return 5;
        } else if (s.length() <= 7) {
            return 10;
        } else {
            return 25;
        }
    }

    static int num(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num++;
            }
        }

        if (num == 0) return 0;
        else if (num == 1) {
            return 10;
        } else {
            return 20;
        }
    }

    static int ischar(String s) {
        boolean hasUpper = false;
        boolean hasLower = false;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
        }

        if (!hasUpper && !hasLower) {
            return 0;  // 没有字母
        } else if (hasUpper && hasLower) {
            return 20; // 大小写混合
        } else {
            return 10; // 全部大写或全部小写
        }
    }


    static int fuhao(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            if ((c >= 0x21) && (c <= 0x2f)) {
                num++;
            } else if ((c >= 0x3A) && (c <= 0x40)) {
                num++;
            } else if ((c >= 0x5B) && (c <= 0x60)) {
                num++;
            } else if ((c >= 0x7B) && (c <= 0x7E)) {
                num++;
            }
        }

        if (num == 0) return 0;
        else if (num == 1) {
            return 10;
        } else {
            return 25;
        }
    }
}

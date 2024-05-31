package com.pandy.huawei.simulation._01;

import java.util.Scanner;

public class HJ33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if (s.contains(".")) {
                ip2Ten(s);
            } else {
                ten2Ip(Long.parseLong(s));
            }
        }
    }

    static void ip2Ten(String ip) {
        String[] split = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 256 + Integer.parseInt(split[i]);
        }
        System.out.println(result);
    }

    static void ten2Ip(Long num) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result = num % 256 + "." + result;
            num /= 256;
        }
        System.out.println(result.substring(0, result.length() - 1));
    }

}

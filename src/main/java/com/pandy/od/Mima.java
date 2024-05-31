package com.pandy.od;

import java.util.Scanner;

public class Mima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        boolean isBig = false;
        boolean isSmall = false;
        boolean isNum = false;
        boolean isSpec = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() -1);
                }
            } else {
                result.append(c);
            }
        }

        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (Character.isDigit(c)) {
                isNum = true;
            }

            else if (Character.isLowerCase(c)) {
                isSmall = true;
            }

            else if (Character.isUpperCase(c)) {
                isBig = true;
            }

            else {
                isSpec = true;
            }
        }

        boolean flagRes = result.length() >= 8 && isNum && isBig && isSmall && isSpec;
        System.out.println(result +","+flagRes);
    }
}

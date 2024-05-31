package com.pandy.huawei.simulation._03;

import java.util.Scanner;

public class HJ63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dnaSequence = scanner.nextLine();
        int substringLength = scanner.nextInt();
        System.out.println(findHighestGCRatioSubstring(dnaSequence, substringLength));
    }

    private static String findHighestGCRatioSubstring(String dnaSequence, int substringLength) {

        double maxGCRatio = -1;
        String resultSubstring = "";
        int sequenceLength = dnaSequence.length();

        for (int start = 0; start <= sequenceLength - substringLength; start++) {
            // 这是一个固定的滑动窗口
            String substring = dnaSequence.substring(start, start + substringLength);
            int gcCount = 0;
            for (int i = 0; i < substring.length(); i++) {
                char ch = substring.charAt(i);
                if (ch == 'G' || ch == 'C') {
                    gcCount++;
                }
            }
            double gcRatio = (double) gcCount / substringLength;
            if (gcRatio > maxGCRatio) {
                maxGCRatio = gcRatio;
                resultSubstring = substring;
            }
        }
        return resultSubstring;
    }
}

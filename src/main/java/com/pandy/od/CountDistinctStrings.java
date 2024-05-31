package com.pandy.od;

import java.util.HashSet;
import java.util.Scanner;

public class CountDistinctStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        String str = parts[0];
        int length = Integer.parseInt(parts[1]);
        int count = countDistinctStrings(str, length);
        System.out.println(count);
    }

    private static int countDistinctStrings(String str, int length) {
        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[str.length()];
        generateDistinctStrings(str, length, "", set, used);
        return set.size();
    }

    private static void generateDistinctStrings(String str, int length, String current, HashSet<String> set, boolean[] used) {
        if (current.length() == length) {
            set.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i] || current.length() > 0 && current.charAt(current.length() - 1) == str.charAt(i)) {
                continue;
            }
            used[i] = true;
            generateDistinctStrings(str, length, current + str.charAt(i), set, used);
            used[i] = false;
        }
    }
}

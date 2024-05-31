package com.pandy.od;

import com.pandy.base.tree.traversal.In;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());

        String[] lines = new String[count];
        for (int i = 0; i < count; i++) {
            lines[i] = in.nextLine();
        }

        String[] s = in.nextLine().split(" ");
        int layer = Integer.parseInt(s[0]);
        String key = s[1];
        search(lines, layer, key);
    }

    public static void search(String[] paths, int layer, String key) {
        int count = 0;
        for (String path : paths) {
            String[] split = path.split("/");
            if (split.length >= layer + 1 && split[layer].equals(key)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

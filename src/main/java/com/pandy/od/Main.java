package com.pandy.od;

import com.pandy.base.tree.traversal.In;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int xiaoming = scanner.nextInt();
        int numFriends = scanner.nextInt();

        ArrayList<Integer> friendsHeight = new ArrayList<>();

        for (int i = 0; i < numFriends; i++) {
            int height = scanner.nextInt();
            friendsHeight.add(height);
        }

        Collections.sort(friendsHeight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int dif1 = Math.abs(o1 - xiaoming);
                int dif2 = Math.abs(o2 - xiaoming);
                if (dif2 == dif1) {
                    return o1 - o2;
                }
                return dif1 - dif2;
            }
        });

        for (Integer integer : friendsHeight) {
            System.out.println(integer + " ");
        }
    }
}

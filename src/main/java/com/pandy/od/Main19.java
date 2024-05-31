package com.pandy.od;

import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] seats = scanner.nextLine().toCharArray();
        int maxAdditional = 0;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0 && (i == 0 || seats[i-1] == '0') && (i == seats.length - 1 || seats[i+1] == '0')) {
                maxAdditional++;
                seats[i] = '1';
                i++;
            }
        }
        System.out.println(maxAdditional);
    }
}

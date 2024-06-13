package com.pandy.huawei.three;

public class A344_ReverseString {
    public void reverse(char[] s) {
        int size = s.length;
        for (int i = 0; i < s.length / 2; i++) {
            size --;
            char temp = s[i];
            s[i] = s[size];
            s[size] = temp;
        }
    }
}

package com.pandy.huawei.shousi;

public class Compress {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        int compress1 = compress.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
        System.out.println("compress1 = " + compress1);
    }
}

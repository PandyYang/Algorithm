package com.pandy.huawei.three;

public class A165_CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int n = split1.length;
        int m = split2.length;

        for (int i = 0; i < Math.max(m, n); i++) {
            int a = i < n ? Integer.parseInt(split1[i]) : 0;
            int b = i < m ? Integer.parseInt(split2[i]) : 0;
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = new A165_CompareVersion().compareVersion("1.2", "1.10");
        System.out.println("i = " + i);
    }
}

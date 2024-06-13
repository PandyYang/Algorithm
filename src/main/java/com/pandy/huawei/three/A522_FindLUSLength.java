package com.pandy.huawei.three;

import java.util.Arrays;

public class A522_FindLUSLength {
    public int findLUSLength(String[] strs) {
        Arrays.sort(strs, (a1, a2) -> a2.length() - a1.length());
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            if (isUncommon) {
                return strs[i].length();
            }
        }
        return -1;
    }

    private boolean isSubsequence(String a, String b) {
        int i =0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }
}

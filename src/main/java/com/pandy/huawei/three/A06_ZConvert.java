package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 */
public class A06_ZConvert {
    public String convert(String s, int numRows) {

        StringBuilder res = new StringBuilder();

        List<StringBuilder> list = new ArrayList<>();

        int flag = -1;
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int i = 0; flag = -flag;
        for (char c : s.toCharArray()) {

            list.get(i).append(c);

            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }

        return res.toString();
    }
}

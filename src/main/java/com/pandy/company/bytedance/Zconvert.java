package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * z字型变换
 */

class Zconvert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);

            //  i为0或最后一个 分别加1 或者减去 1 z字形振动
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }
}

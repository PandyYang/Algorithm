package com.pandy.base.array;

public class MaxProduct {

    public int maxProduct(String[] words) {
        // ��¼ÿ���������ÿ��Ԫ�س��ֵ�λ�� ע��Ĭ������λ����false
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    // ����һ����������������
                    // ÿ���������ÿ��λ�� ���� �鿴�Ƿ������ͬ��Ԫ��
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                // kΪ26 ˵��û���ظ��ġ�
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}

package com.pandy.base.math;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // ���õ����ַ�ת��Ϊ��Ӧ������ֵ���� ASCII �� Unicode �����У������ַ� '0' �� '9' ���������еģ��� '0' �ı���ֵ�� 48�����ԣ�������ַ� '0' �м�ȥ '0' ʱ����õ��������� 0�����ַ� '1' �м�ȥ '0'����õ��������� 1���Դ����ơ�����һ�����ַ���ʾ������ת��Ϊʵ������ֵ�Ŀ�ݷ�����
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? a.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2? sum - 2 : sum;
            sb.append(sum);
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 10;  // ��ʮ�����У���λ���ܺͳ���10�Ľ��
            sum = sum % 10;    // ��ǰλ���������ܺͳ���10������
            sb.append(sum);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }


}

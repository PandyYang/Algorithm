package com.pandy.huawei.simulation._05;

import java.util.*;

public class HJ95 {
    static HashMap<Character, String> map;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] split = input.split("\\.");

        map = new HashMap<>();
        map.put('0', "零");
        map.put('1', "壹");
        map.put('2', "贰");
        map.put('3', "叁");
        map.put('4', "肆");
        map.put('5', "伍");
        map.put('6', "陆");
        map.put('7', "柒");
        map.put('8', "捌");
        map.put('9', "玖");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("人民币");
        stringBuffer.append(evaluateInteger(split[0]));
        stringBuffer.append(evaluateFloat(split[1]));
        System.out.println(stringBuffer);
    }

    private static String evaluateInteger(String s) {//1234
        String result = "";
        int length = s.length();

        ArrayList<String> list = new ArrayList<>();

        for (int i = length - 1; i >= 0; i = i - 4) {
            String substring = s.substring(i - 3 >= 0 ? i - 3 : 0, i + 1);
            list.add(substring);
        }
        for (int i = 0; i < list.size(); i++) {
            result = getResult(list.get(i), i) + result;
        }
        return result;
    }

    private static String getResult(String s, int i) {
        String result = "";
        switch (s.length()) {
            case 1:
                result = s.charAt(0) == '0' ? "" : map.get(s.charAt(0));
                break;
            case 2:
                result = (s.charAt(0) == '1' ? "拾" : map.get(s.charAt(0)) + "拾") +
                        (s.charAt(1) == '0' ? "" : (map.get(s.charAt(1)) + ""));
                break;
            case 3:
                result = (map.get(s.charAt(0)) + "佰") + (s.charAt(1) == '0' ? (s.charAt(
                        2) == '0' ? "" : "零") : (s.charAt(1) == '1' ? "拾" : map.get(s.charAt(
                        1)) + "拾")) + (s.charAt(2) == '0' ? "" : (map.get(s.charAt(2)) + ""));
                break;
            case 4:
                result = (map.get(s.charAt(0)) + "仟") + (s.charAt(1) == '0' ? (s.charAt(
                        2) == '0' ? "" : "零") : (map.get(s.charAt(1)) + "佰")) + (s.charAt(
                        2) == '0' ? (s.charAt(3) == '0' ? "" : "零") : (s.charAt(
                        2) == '1' ? "拾" : map.get(s.charAt(2)) + "拾")) + (s.charAt(
                        3) == '0' ? "" : (map.get(s.charAt(3)) + ""));
                break;
            default:
                return "";
        }
        if (result.length() > 0) {
            switch (i) {
                case 0:
                    result += "元";
                    break;
                case 1:
                    result += "万";
                    break;
                case 2:
                    result += "亿";
                    break;
                default:
                    return "";
            }
        }
        return result;
    }

    private static String evaluateFloat(String s) {
        if (s.equals("00")) {
            return "整";
        } else {
            return (s.charAt(0) == '0' ? "" : (map.get(s.charAt(0)) + "角")) + (s.charAt(
                    1) == '0' ? "" : (map.get(s.charAt(1)) + "分"));
        }
    }
}

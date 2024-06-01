package com.pandy.od;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Pattern p = Pattern.compile("(\\d+)\\$(\\d+)");
        while (true) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                String subS = m.group(0);
                int x = Integer.parseInt(m.group(1));
                int y = Integer.parseInt(m.group(2));
                s = s.replaceAll(p.pattern(), Integer.toString(3 * x + y + 2));
            } else {
                break;
            }
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        String delimiter = "#";
        int pos = 0;
        while ((pos = s.indexOf(delimiter)) != -1) {
            String token = s.substring(0, pos);
            arr.add(Integer.parseInt(token));
            s = s.substring(pos + delimiter.length());
        }
        arr.add(Integer.parseInt(s));

        int x = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            x = 2 * x + 3 * arr.get(i) + 4;
        }
        System.out.println(x);
        return;
    }

}

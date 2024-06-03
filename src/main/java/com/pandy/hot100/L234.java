package com.pandy.hot100;

import com.pandy.common.ListNode;

import java.util.ArrayList;
import java.util.Objects;

public class L234 {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (Objects.equals(list.get(i), list.get(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

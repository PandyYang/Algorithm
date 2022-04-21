package com.pandy.base.traceback;

import java.util.*;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class SubArraysDivByK {

    public int divByK(int[] nums, int k) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int modulus = (sum % k + k) % k;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    /////////////////////////////////////////下方胡言乱语


    public int subarraysDivByK(int[] nums, int k) {
        List<List<Integer>> permutation = permutation(nums);
        return 1;
    }

    // 使用回溯法求解全排列
    public List<List<Integer>> permutation(int[] nums) {

        Deque<Integer> cur = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] valid = new boolean[nums.length];
        dfs(res, valid, 0, nums, cur);
        return res;
    }

    public void dfs(List<List<Integer>> res, boolean[] valid, int pos, int[] nums, Deque<Integer> cur) {
        if (nums.length == pos) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (valid[i]) return;
            cur.addLast(nums[i]);
            valid[i] = true;
            dfs(res, valid, pos + 1, nums, cur);
            cur.removeLast();
            valid[i] = false;
        }
    }

    public static void main(String[] args) {
        SubArraysDivByK subArraysDivByK = new SubArraysDivByK();
        int i = subArraysDivByK.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(i);
    }
}

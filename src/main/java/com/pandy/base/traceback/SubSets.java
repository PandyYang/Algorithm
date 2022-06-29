package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/27
 * <p>
 * 求子集
 **/
public class SubSets {

    public List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subSets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    /////////////////////////////////////////////////////////////////////////////////


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                ArrayList<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}

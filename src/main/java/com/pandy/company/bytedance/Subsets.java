package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 求数组的所有子集
 * <p>
 * * 上面的代码中，{dfs}(it{cur}, n)dfs(cur,n) 参数表示当前位置是 it{cur}cur，
 * * 原序列总长度为 nn。原序列的每个位置在答案序列中的状态有被选中和不被选中两种，
 * * 我们用 tt 数组存放已经被选出的数字。在进入 {dfs}(it{cur}, n)dfs(cur,n)
 * * 之前 [0, it{cur} - 1][0,cur−1] 位置的状态是确定的，而 [it{cur}, n - 1][cur,n−1]
 * * 内位置的状态是不确定的，{dfs}(it{cur}, n)dfs(cur,n) 需要确定 it{cur}cur 位置的状态，
 * * 然后求解子问题 {{dfs}(cur + 1}, n)dfs(cur+1,n)。对于 it{cur}cur 位置，我们需要考虑
 * * a[it{cur}]a[cur] 取或者不取，如果取，我们需要把 a[it{cur}]a[cur] 放入一个临时的答案数组中
 * * （即上面代码中的 tt），再执行 {{dfs}(cur + 1}, n)dfs(cur+1,n)，执行结束后需要对 tt 进行回溯；如果不取，
 * * 则直接执行 {{dfs}(cur + 1}, n)dfs(cur+1,n)。在整个递归调用的过程中，it{cur}cur 是从小到大递增的，
 * * 当 it{cur}cur 增加到 nn 的时候，记录答案并终止递归。可以看出二进制枚举的时间复杂度是 O(2 ^ n)O(2n)
 */
public class Subsets {

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        subsets1.forEach(System.out::println);
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            // 记录答案
            ans.add(new ArrayList<>(t));
            return;
        }

        // 考虑当前位置
        t.add(nums[cur]);
        dfs(cur + 1, nums);

        // 不考虑当前位置
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}

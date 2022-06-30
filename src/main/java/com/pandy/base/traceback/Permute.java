package com.pandy.base.traceback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/26
 * <p>
 * 数组的全排列
 * <p>
 * 树的广度优先遍历以及深度优先遍历
 * 深度优先也称为回溯
 * 状态：每一个节点表示了求解问题的不同阶段
 * 状态变量：
 * 1、递归到了第几层 depth
 * 2、已经选择了哪些数 path
 * 3、布尔数组used
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    /**
     * @param nums  当前需要处理的数组
     * @param len   当前数组长度
     * @param depth 当前递归到了第几层
     * @param path  当前已选择的数
     * @param used  当前的数是否被使用
     * @param res   收集结果
     */
    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {

        // 中止条件： 当前递归的层数等于数组的长度
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            // 判断当前数是否已被使用
            if (used[i]) {
                continue;
            }

            // 没有使用加入到路径
            path.addLast(nums[i]);
            // 加入之后标记一下
            used[i] = true;
            // 路径增加 继续递归
            dfs(nums, len, depth + 1, path, used, res);
            // 逆操作 回溯 需要返回上层节点 继续向下搜索 因为depth已经+1
            path.removeLast();
            used[i] = false;
        }
    }
}

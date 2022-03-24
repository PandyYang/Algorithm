package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/24
 * 组合总和
 **/
public class CombinationSum {

    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    List<Integer> list=new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序，方便剪枝
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] candidates,int target,int index){
        if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        //记录起始位置
        for(int i=index;i<candidates.length;i++){
            //经过了排序，加速剪枝
            if(target-candidates[i]<0){
                break;
            }
            //加入
            list.add(candidates[i]);
            //注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错,不是index,如果是index，那么就变成排列了，会得到重复组合
            dfs(candidates,target-candidates[i],i);
            //删除
            list.remove(list.size()-1);
        }
    }

}

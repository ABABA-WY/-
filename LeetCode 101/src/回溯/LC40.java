package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    //回溯加剪枝
    List<List<Integer>> ans=new ArrayList<>();
    int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        len=candidates.length;
        dfs(candidates,target,new ArrayList<>(),0,0);
        return ans;
    }
    //用begin 来记录当前位置，防止后面的选择前面的数
    public void dfs(int[] candidates, int target,List<Integer> list,int sum,int begin){
        if(sum==target){
            if(!ans.contains(list))
                ans.add(new ArrayList<>(list));
            return;
        }
        //每次从begin开始遍历
        for(int i=begin;i<len;i++){
            //这里剪枝
            if(sum+candidates[i]>target){
                return;
            }
            //这里也剪枝
            //防止出现重复情况
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            sum+=candidates[i];
            list.add(candidates[i]);
            dfs(candidates,target,list,sum,i+1);
            sum-=candidates[i];
            list.remove(list.size() - 1);
        }
    }

}

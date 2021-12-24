package 图论;

import java.util.*;

public class LC46 {
    //只回溯
    /*List<List<Integer>> ans=new ArrayList<List<Integer>>();
    boolean[] visited;
    int len;
    public List<List<Integer>> permute(int[] nums) {
        len=nums.length;
        visited=new boolean[len];
        dfs(nums,new ArrayList<Integer>());
        return ans;
    }
    public void dfs(int[] nums,List<Integer> list){
        if(list.size()==len){
            //list 公用一个内存地址
            //如果只是add(list) 的话，最终ans中的链表内容为空
            //所以要创建一片新内存地址
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<len;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(nums[i]);
                dfs(nums,list);
                visited[i]=false;
                list.remove(list.size()-1);
            }
        }
    }*/
    //回溯加剪枝
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    boolean[] visited;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        visited = new boolean[len];
        dfs(nums, new ArrayList<Integer>());
        return ans;
    }

    public void dfs(int[] nums, List<Integer> list) {
        if (list.size() == len) {
            //list 公用一个内存地址
            //如果只是add(list) 的话，最终ans中的链表内容为空
            //所以要创建一片新内存地址
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            //回溯的时候，如果是相同的数字，然后前面的数字没有访问过，
            // 说明现在的数字要在相同的那个没有访问过的数字前面。而这种情况已经发生过了，所以continue；
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]))
                continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

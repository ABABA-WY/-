package 回溯;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,new ArrayList<>(),1);
        return ans;
    }

    public void dfs(int n, int k, List<Integer> list, int begin) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i <= n-(k-list.size()); i++) {
            list.add(i);
            dfs(n,k,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}

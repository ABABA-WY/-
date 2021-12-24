package Daly;

import java.util.*;

public class LC230 {
    private List<Integer> ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = new ArrayList<Integer>();
        dfs(root);
        return ans.get(k-1);
    }
    public void dfs(TreeNode root){
        while(root==null){
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}

package 树与图;

import java.util.LinkedList;
import java.util.List;

public class LC94_DFS {
    List<Integer> ans= new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null)
            dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root.left!=null)
            dfs(root.left);
        ans.add(root.val);
        if(root.right!=null)
            dfs(root.right);
    }
}

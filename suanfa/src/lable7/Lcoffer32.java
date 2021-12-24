package lable7;

import java.util.*;

public class Lcoffer32 {
    private List<List<Integer>> ret;
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root){
        ret=new ArrayList<>();
        return ret;
    }
    private void dfs(int depth, TreeNode root){
        if (root == null) {
            return;
        }
        if(ret.size() == depth)
            ret.add(new ArrayList<>());
        ret.get(depth).add(root.val);
        dfs(depth+1,root.left);
        dfs(depth+1,root.right);
    }
}

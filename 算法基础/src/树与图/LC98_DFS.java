package 树与图;

public class LC98_DFS {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode root,long lower,long upper){
        if(root==null)
            return false;
        if(root.val<=lower||root.val>=upper)
            return false;
        return dfs(root.left,lower,root.val)&&dfs(root.right,root.val,upper);

    }
}

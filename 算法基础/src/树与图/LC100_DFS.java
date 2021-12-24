package 树与图;

public class LC100_DFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        else if(p==null||q == null)
            return false;
        else if(p.val!= q.val)
            return false;
        else
            return dfs(p.left, q.left)&&dfs(p.right, q.right);
    }
}

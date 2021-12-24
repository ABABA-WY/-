package 图论;

import java.util.Deque;
import java.util.LinkedList;

public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val)
            return root;
        return val<root.val?searchBST(root.left, val):searchBST(root.right, val);
    }
}

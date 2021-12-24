package Daly;

public class LC437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = Sum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int Sum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += Sum(root.left, targetSum - val);
        ret += Sum(root.right, targetSum - val);
        return ret;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
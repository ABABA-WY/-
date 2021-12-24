package Daly;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class LC559 {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int ans=0;
        for (int j = 0; j < root.children.size(); j++) {
            if (root.children.get(j)!=null) {
                ans=Math.max(ans, maxDepth(root.children.get(j)));
            }
        }
        return ans;
    }

}

package 树与图;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class LC116_BFS {
/*    public Node connect(Node root) {
        if(root==null)
            return null;
        Node ans=root;
        LinkedList<Node> q = new LinkedList<Node>();
        q.offer(ans);
        while (!q.isEmpty()) {
            int size=q.size();
            for(int i=0;i < size-1; i++){
                q.get(i).next=q.get(i+1);
            }
            for (int i = 0; i < size; i++) {
                Node temp=q.remove(i);
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return ans;
    }*/
    public Node connect(Node root){
        if(root==null)
            return null;
        Node ans=root;
        while(ans.left!=null){
            Node temp=ans;
            while(temp!=null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp=temp.next;
            }
            ans=ans.left;
        }
        return root;
    }
}

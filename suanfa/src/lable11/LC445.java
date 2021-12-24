package lable11;

import java.util.Deque;
import java.util.LinkedList;

public class LC445 {
    public static void main(String[] args) {
        ListNode l1;
        ListNode l2;
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=null;
        int d=0;
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2=l2.next;
        }
        while(!stack1.isEmpty()||!stack2.isEmpty()||d != 0){
            int a=stack1.isEmpty()?0:stack1.pop();
            int b=stack2.isEmpty()?0:stack2.pop();
            int x=a+b+d;
            d=x/10;
            int m=x%10;
            ListNode l3 = new ListNode();
            l3.val=m;
            l3.next=ans;
            ans=l3;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
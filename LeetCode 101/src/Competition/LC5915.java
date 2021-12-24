package Competition;

import java.util.ArrayList;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class LC5915 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int max=-1;
        int min=Integer.MAX_VALUE;
        int i=0;
        List<Integer> ans=new ArrayList<Integer>();
        while(head.next.next!=null){
            i++;
            if(head.next.val>head.val&&head.next.val>head.next.next.val){
                ans.add(i);
            }
            else if(head.next.val<head.val&&head.next.val<head.next.next.val){
                ans.add(i);
            }
            head=head.next;
        }
        if (ans.size() >= 2) {
            max= ans.get(ans.size() - 1)-ans.get(0);
            for(int j=0;j<ans.size()-1; j++){
                min =Math.min(min,ans.get(j+1)-ans.get(j));
            }
            return new int[]{min,max};
        }
        return new int[] {-1,-1};
    }
}

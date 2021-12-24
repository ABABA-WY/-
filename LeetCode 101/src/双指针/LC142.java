package 双指针;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class LC142 {
    public static void main(String[] args) {
        ListNode head=null;
        ListNode fast=head;
        ListNode low=head;
        while (true){
            if(fast==null||fast.next==null) return;
            fast=fast.next.next;
            low=low.next;
            if(fast==low) break;
        }
        fast=head;
        while(fast!=low){
            fast = fast.next;
            low=low.next;
        }
        return;
    }
}

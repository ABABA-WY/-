package lable1;

public class diedai {
    public main.ListNode reserListNode(main.ListNode head){
        main.ListNode preve=null;
        main.ListNode curr=head,next;
        while (curr != null) {
            next=curr.next;
            curr.next=preve;
            preve=curr;
            curr=next;
        }
        return preve;
    }
}

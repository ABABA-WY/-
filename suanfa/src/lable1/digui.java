package lable1;

public class digui {
    public static main.ListNode recursion(main.ListNode head){
        if(head==null||head.next == null)
            return head;
        main.ListNode newHead=recursion(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}

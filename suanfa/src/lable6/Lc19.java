package lable6;

public class Lc19 {
    public static void main(String[] args) {
        Lc19 t=new Lc19();
        ListNode[] a =new ListNode[6];
        a[a.length - 1]=new ListNode(a.length,null);
        for (int i = a.length-2; i >=0; i--){
            a[i]=new ListNode(i+1,a[i+1]);
        }
        ListNode result=t.removeNthFromEnd(a[0],6 );
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp =head;
        ListNode cur=new ListNode(0,head);
        int count=0;
        while (temp != null) {
            count++;
            temp=temp.next;
        }
        temp=cur;
        for (int i = 0; i < count-n; i++) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return temp.next;
    }
}

package 数据结构;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        int carry=0;
        while(l1!=null||l2 != null ){
            int n1=l1!=null? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum=n1+n2+carry;
            carry=sum/10;
            sum%=10;
            cur.next=new ListNode(sum);
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(carry==1){
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}

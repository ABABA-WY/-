package lable6;

public class Lc876 {
    public static void main(String[] args) {
        Lc876 t=new Lc876();
        ListNode[] a =new ListNode[6];
        a[a.length - 1]=new ListNode(a.length,null);
        for (int i = a.length-2; i >=0; i--){
            a[i]=new ListNode(i+1,a[i+1]);
        }

        System.out.println(t.middleNode(a[0]).val);
    }


    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp=head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        for (int i = 0; i < count/2; i++) {
            head=head.next;
        }
        return head;
    }
}

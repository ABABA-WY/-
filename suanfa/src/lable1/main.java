package lable1;

public class main {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static void main(String[] args) {
        ListNode[] node = new ListNode[5];
        node[4] = new ListNode(5,null);
        for (int i = 3; i >= 0; i--) {
            node[i] = new ListNode(i+1,node[i+1]);
        }
        ListNode head1=node[0];
        main TestNode=new main();
       // TestNode.test1(head1);
        ListNode head2=node[0];
        TestNode.test2(head2);
    }
    public void test1(ListNode head){
        diedai fun=new diedai();
        ListNode preve=fun.reserListNode(head);
        while(preve!=null){
            System.out.println(preve.val);
            preve=preve.next;
        }
    }
    public void test2(ListNode head){
        ListNode newHead=digui.recursion(head);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }

}

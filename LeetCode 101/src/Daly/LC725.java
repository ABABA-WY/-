package Daly;

public class LC725 {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode sb = head;
        ListNode[] ans = new ListNode[k];
        int n = 0;
        while (sb != null) {
            n++;
            sb = sb.next;
        }
        int d = n / k;
        int m = n % k;
        ListNode curr=head;
        for (int i = 0; i < k&&curr!=null; i++) {
            ans[i] = curr;
            int a=d+(i<m ? 1 : 0);
            for (int j = 1; j < a; j++) {
                curr = curr.next;
            }
            ListNode next=curr.next;
            curr.next=null;
            curr=next;
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

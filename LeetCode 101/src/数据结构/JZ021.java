package 数据结构;

public class JZ021 {
    //正常解法
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        len++;
        if (len == 1)
            return null;
        if (len == n) {
            head = head.next;
            return head;
        }
        p = head;
        for (int i = 1; i < len - n; i++) {
            p = p.next;
        }
        p.next = p.next.next == null ? null : p.next.next;
        return head;
    }
*/
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //考虑到删除头结点的问题，所以创建另一个头结点
        ListNode domy = new ListNode(0, head);
        ListNode fast = head, low = domy;
        //fast先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
        //令low指向要被删除的节点
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return domy.next;
    }
}

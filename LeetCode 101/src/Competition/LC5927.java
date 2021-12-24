package Competition;

import java.util.*;

public class LC5927 {
    List<Integer> list = new ArrayList<Integer>();

    public ListNode reverseEvenLengthGroups(ListNode head) {
        int n = getLength(head);
        List<Integer> cures;
        int cur_len = 1;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //从0开始
        int i = 0;
        while (i < n) {
            //取出该段，同时注意边界问题
            cures = new ArrayList<>(list.subList(i, Math.min(i + cur_len, n)));
            if (cures.size() % 2 == 0) {
                //用Collection类的reverse将链表反转
                Collections.reverse(cures);
            }
            for (int j = 0; j < cures.size(); j++) {
                p.next = new ListNode(cures.get(j));
                p = p.next;
            }
            i += cur_len;
            cur_len++;
        }
        return dummy.next;
    }


    public int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            list.add(head.val);
            head = head.next;
            n++;
        }
        return n;
    }
}

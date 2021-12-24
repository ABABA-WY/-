package 字符串;

import java.util.Deque;
import java.util.LinkedList;

public class LC71 {
    public static void main(String[] args) {
        String path = "/home//foo/";

        System.out.println(new LC71().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        int n = path.length();
        Deque<String> q = new LinkedList<String>();
        int i = 0;
        while (i < n) {
            if (path.charAt(i) == '/') {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                for (; i < n && path.charAt(i) != '/'; i++) {
                    sb.append(path.charAt(i));
                }
                if (sb.toString().equals(".")) {
                    continue;
                } else if (sb.toString().equals("..")) {
                    if (!q.isEmpty()) {
                        q.removeFirst();
                    }
                } else {
                    q.addFirst(sb.toString());
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        if (q.isEmpty()) return new String("/");
        while (!q.isEmpty()) {
            ans.append("/");
            ans.append(q.removeLast());
        }
        int j = ans.length() - 1;
        for (j = ans.length() - 1; j >= 0; j--) {
            if (ans.charAt(j) != '/') break;
        }
        return ans.toString().substring(0, j + 1);
    }
}

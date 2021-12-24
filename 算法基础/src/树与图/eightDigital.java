package 树与图;

import java.util.*;

public class eightDigital {
    public static Queue<String> q = new ArrayDeque<>();
    public static Map<String, Integer> ans = new HashMap<>();
    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static String s;
    public static int n = 9;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String start = "";
        for (int i = 1; i <= 9; i++) {
            String ch = scan.next();
            start += ch;
        }
        ans.put(start, 0);
        q.offer(start);
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            s = q.poll();
            if (s.equals("12345678x"))
                return ans.get(s);
            int a = s.indexOf('x');
            int x = a / 3, y = a % 3;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                if (xx < 0 || xx >= 3 || yy < 0 || yy >= 3)
                    continue;
                int l = xx * 3 + yy;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 9; j++) {
                    if (j == l) sb.append('x');
                    else if (j == a) sb.append(s.charAt(l));
                    else sb.append(s.charAt(j));
                }
                if (!ans.containsKey(sb.toString())) {
                    ans.put(sb.toString(), ans.get(s) + 1);
                    q.offer(sb.toString());
                }
            }
        }
        return -1;
    }
}

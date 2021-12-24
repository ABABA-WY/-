import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LC2387 {
    public static final int N = 1010;
    public static final int maxNum = 0x3f3f3f3f;
    public static int n, m;
    public static int[] dist = new int[N];//距离
    public static boolean[] st = new boolean[N];
    public static int[][] map = new int[N][N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], -1);
        }
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            if (map[a][b] == -1 || c < map[a][b]) {
                map[a][b] = c;
                map[b][a] = c;
            }
        }
        System.out.println(spfa());
    }

    public static int spfa() {
        Arrays.fill(dist, maxNum);
        dist[1] = 0;
        st[1] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        while (q.size() > 0) {
            int t = q.poll();
            st[t] = false;
            for (int i = 1; i <= n; i++) {
                if (map[t][i] != -1) {
                    if (dist[i] > dist[t] + map[t][i]) {
                        dist[i] = dist[t] + map[t][i];
                        //System.out.println(i+" "+dist[i]);
                        if (!st[i]) {
                            q.add(i);
                            st[i] = true;
                        }
                    }

                }

            }
        }
        return dist[n];
    }
}

package 树与图;

import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    public static int N = 510, INF = 0x3f3f3f3f;
    public static int n, m;
    public static int[][] g = new int[N][N];
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int w = input.nextInt();
            g[a][b] = Math.min(g[a][b], w);
        }
        int t = prim();
        if (t == INF)
            System.out.println("impossible");
        else
            System.out.println(t);
    }

    public static int prim() {
        Arrays.fill(st, false);
        Arrays.fill(dist, INF);
        int res = 0;
        //迭代n次
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                //找到距离集合最近的点
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            //无法联通
            if (i > 0 && dist[t] == INF)
                return INF;
            //将这个距离加到总距离中
            //第一次的不用加
            if (i > 0) res += dist[t];
            st[t] = true;
            for (int k = 1; k <= n; k++) {
                //更新其他点的距离
                dist[k] = Math.min(dist[k], g[t][k]);
            }
        }
        return res;
    }
}

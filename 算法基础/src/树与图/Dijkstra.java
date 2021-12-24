package 树与图;

import java.util.Arrays;
import java.util.Scanner;

/*
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为正值。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。

输入格式
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 −1。

数据范围
1≤n≤500,
1≤m≤105,
图中涉及边长均不超过10000。
*/
public class Dijkstra {
    public static final int maxNum = 0x3f3f3f3f;
    public static int n, m;
    public static int[] dist;//距离
    public static int[][] g;//邻接矩阵
    public static boolean[] st;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        dist = new int[n + 1];
        g = new int[n + 1][n + 1];
        st = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], maxNum);
        }
        while (m != 0) {
            m--;
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            g[a][b] = Math.min(g[a][b], c);//建立矩阵，并减去多重边
            // System.out.println(g[a][b]);
        }
        int ans = dijkstra();
        System.out.println(ans);
    }

    public static int dijkstra() {
        Arrays.fill(dist, maxNum);
        dist[1] = 0;
        for (int i = 1; i <= n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            if (t == n)
                break;
            st[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
                //  System.out.println(dist[j]);
            }
        }
        return dist[n] == 10001 ? -1 : dist[n];
    }
}

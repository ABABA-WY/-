package 树与图;

/*
给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环， 边权可能为负数。

请你求出从 1 号点到 n 号点的最多经过 k 条边的最短距离，如果无法从 1 号点走到 n 号点，输出 impossible。

注意：图中可能 存在负权回路 。

输入格式
第一行包含三个整数 n,m,k。

接下来 m 行，每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示从 1 号点到 n 号点的最多经过 k 条边的最短距离。

如果不存在满足条件的路径，则输出 impossible。
 */
import java.sql.Struct;
import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int a, b, w;
    public Edge(){
        a=0;
        b=0;
        w=0;
    }
    public Edge(int i, int j,int k){
        a = i;
        b = j;
        w = k;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

}

public class Bellman_Ford {
    public static int N = 510, M = 10010;
    public static int n, m, k;
    public static int[] dist = new int[N];
    public static int[] backup = new int[N];//上一次操作的dist，防止路径串联
    public static Edge[] edges;
    public static final int maxNum = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge();
            edges[i].a = in.nextInt();
            edges[i].b = in.nextInt();
            edges[i].w = in.nextInt();
        }
        int res = bellman_ford();
        if (res == maxNum / 2)
            System.out.println("impossible");
        else
            System.out.println(res);
    }

    public static int bellman_ford() {
        Arrays.fill(dist, maxNum);
        dist[1] = 0;
        for (int i = 0; i < k; i++) {
            backup = dist.clone();
            for (int j = 0; j < m; j++) {
                int a = edges[j].a, b = edges[j].b, w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }
        }
        if (dist[n] > maxNum / 2) return maxNum / 2;
        return dist[n];
    }
}

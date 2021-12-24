package 树与图;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
    public static int N = 10010;
    public static int n, m;
    public static int[] p;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        p = new int[n + 1];
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            edges[i] = new Edge(a, b, c);
        }
        //按照w进行排序
        Arrays.sort(edges, (a, b) -> {
            return a.w - b.w;
        });
        //将每个点的父亲节点设为自己
        for (int i = 1; i <= n; i++) p[i] = i;

        int res = 0;//所有边的和
        int cnt = 0;//数量
        for (int i = 0; i < m; i++) {
            //找父亲节点
            int a = find(edges[i].a);
            int b = find(edges[i].b);
            //父亲节点不一样
            if (a != b) {
                res += edges[i].w;
                cnt++;
                //a和b指向同一个集合
                p[a] = b;
            }
        }
        if (cnt < n - 1)
            System.out.println("impossible");
        else
            System.out.println(res);
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}

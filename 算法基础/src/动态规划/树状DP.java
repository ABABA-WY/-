package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 树状DP {
    public static int N = 6010;
    public static boolean[] has_father = new boolean[N];//有父亲节点
    public static int[] h = new int[N], ne = new int[N], e = new int[N];
    public static int idx;
    public static int n;
    public static int[] happy;//快乐指数
    public static int[][] f = new int[N][2];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        happy = new int[n+1];
        Arrays.fill(h,-1);
        for (int i = 1; i <= n; i++) happy[i] = input.nextInt();
        for (int i = 0; i < n-1; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            has_father[a] = true;
            add(b, a);
        }
        int root = 1;
        //找到根节点
        while (has_father[root]) root++;
        dfs(root);
        System.out.println(Math.max(f[root][0],f[root][1]));
    }

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void dfs(int u) {
        f[u][1] += happy[u];
        //找子节点
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            f[u][0] += Math.max(f[j][0], f[j][1]);
            f[u][1] += f[j][0];
        }
    }
}

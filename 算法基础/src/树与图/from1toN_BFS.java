package 树与图;

import java.util.Arrays;
import java.util.Scanner;

public class from1toN_BFS {
    public static final int N = 10010;
    public static int[] e = new int[N];//存储数据
    public static int[] ne = new int[N];//存储下一个点的坐标
    public static int[] h = new int[N];//头结点
    public static int idx = 0;
    public static int[] q = new int[N];//队列
    public static int[] d = new int[N];//判断是否搜过且存放距离

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
        }
        System.out.println(bfs(n));
    }

    public static void add(int a, int b) {//将a指向b
        e[idx] = b;
        ne[idx] = h[a];//从头部插入
        h[a] = idx++;
    }

    public static int bfs(int n) {
        int hh = 0;
        int tt = 0;
        q[0] = 1;
        Arrays.fill(d, -1);
        d[1] = 0;
        while (hh <= tt) {//队列不为空
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] == -1) {
                    d[j] = d[t] + 1;
                    q[++tt] = j;
                }
            }
        }
        return d[n];
    }
}

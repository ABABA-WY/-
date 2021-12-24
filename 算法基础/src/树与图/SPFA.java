package 树与图;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SPFA {
    public static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in),32768));
    public static final int N = 10010;
    public static final int maxNum = 0x3f3f3f3f;
    public static int n, m;
    public static int[] dist = new int[N];//距离
    public static boolean[] st = new boolean[N];
    public static int[] h, ne, e, w;
    public static int idx = 0;

    public static void main(String[] args) {
        h = new int[N];
        ne = new int[N];
        e = new int[N];
        w = new int[N];
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a, b, c);
        }
        int res = spfa();
        if (res == -1)
            System.out.println();
        else
            System.out.println();
    }

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int spfa() {
        Arrays.fill(dist, maxNum);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        st[1] = true;
        while (queue.size() > 0) {
            int t = queue.poll();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        queue.add(j);
                        st[j] = true;
                    }
                }
            }
        }
        if (dist[n] == maxNum)
            return -1;
        return dist[n];
    }
    public static int nextInt() throws IOException { in.nextToken(); return (int)in.nval; }
}

package 树与图;

import java.util.Arrays;
import java.util.Scanner;

public class 匈牙利_二分图 {
    private static int N = 500, M = 200020;//N为点的个数，M为边的个数，因为为有向图
    private static int[] ne = new int[M], e = new int[M], h = new int[N];//邻接矩阵
    private static int idx;
    private static int[] match = new int[N];//记录当前右侧元素所对应的左侧元素
    private static boolean[] st = new boolean[N];//记录右侧元素是否已被访问过

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int m = input.nextInt();
        Arrays.fill(h, -1);
        while (m-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            add(a, b);
        }

        int res = 0;
        for (int i = 1; i <= n1; i++) {
            Arrays.fill(st, false);
            if (KM(i)) res++;
        }
        System.out.println(res);
    }

    public static boolean KM(int u) {
        for (int i = h[u]; i != -1; i++) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                //如果暂无匹配，或者原来匹配的左侧元素可以找到新的匹配
                if (match[j] == 0 || KM(match[j])) {
                    match[j] = u;//记录当前右侧元素所对应的左侧元素
                    return true;
                }
            }
        }
        return false;

    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

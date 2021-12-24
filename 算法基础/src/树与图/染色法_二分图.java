package 树与图;

import java.util.Arrays;
import java.util.Scanner;

public class 染色法_二分图 {

    private static int N = 100010, M = 200020;//N为点的个数，M为边的个数，因为为有向图
    private static int[] ne = new int[M], e = new int[M], h = new int[N];//邻接矩阵
    private static int idx;
    private static int[] color = new int[N];//表示这个点是否被染色

    public static void main(String[] args) {
        int n, m;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        while (m-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            add(a, b);
            add(b, a);
        }
        //初始化
        Arrays.fill(h,-1);
        //判断是否能成功染色
        //能成功染色说明是二分图
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    //u表示当前点，c表示颜色
    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] != 0) {
                //颜色只有1和2，所以用3-c;
                if (!dfs(j, 3 - c))
                    return false;
            } else if (color[j] == c) {
                return false;
            }
        }
        return true;
    }

    private static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}

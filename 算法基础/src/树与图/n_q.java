package 树与图;

import java.util.Scanner;

//n皇后问题
public class n_q {
    public static final int N = 1000;
    public static int n;//棋盘大小
    public static char[][] g = new char[N][N];//棋盘；
    public static boolean[] row = new boolean[N];//行
    public static boolean[] col = new boolean[N];//列
    public static boolean[] dg = new boolean[N];//正对角线
    public static boolean[] udg = new boolean[N];//反对角线

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        System.out.println(1);
        dfs1(0);
        System.out.println(2);
        dfs2(0, 0, 0);
    }

    public static void dfs1(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[i - u + n]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[i - u + n] = true;
                dfs1(u + 1);
                col[i] = dg[u + i] = udg[i - u + n] = false;
                g[u][i] = '.';
            }
        }
    }

    public static void dfs2(int x, int y, int s) {
        if (y == n) {
            y = 0;
            x++;
        }
        if (x == n) {
            if (s == n) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(g[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            return;
        }

        //放
        if (!row[x] && !col[y] && !dg[x + y] && !udg[y - x + n]) {
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[y - x + n] = true;
            dfs2(x, y + 1, s + 1);
            row[x] = col[y] = dg[x + y] = udg[y - x + n] = false;
            g[x][y] = '.';
        }
        //不放
        dfs2(x, y + 1, s);
    }
}

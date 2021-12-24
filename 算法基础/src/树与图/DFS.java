package 树与图;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static int[] path;
    public static int n;
    public static boolean[] flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        path = new int[n + 1];
        flag = new boolean[n + 1];
        dfs(0);
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                path[u] = i;
                flag[i] = true;
                dfs(u + 1);
                flag[i] = false;
            }
        }
    }
}

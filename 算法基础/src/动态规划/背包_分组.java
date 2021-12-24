package 动态规划;

import java.util.Scanner;

public class 背包_分组 {
    private static int N = 150;
    public static int[][] v = new int[N][N];
    public static int[][] w = new int[N][N];
    public static int[] s = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int k = 1; k <= s[i]; k++) {
                v[i][k] = sc.nextInt();
                w[i][k] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 1; k <= s[i]; k++) {
                    if (v[i][k] <= j) {
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        System.out.println(f[m]);
    }
}

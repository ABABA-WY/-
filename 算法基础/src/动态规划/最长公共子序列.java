package 动态规划;

import java.sql.NClob;
import java.util.Scanner;

public class 最长公共子序列 {
    public static int N = 1010;
    public static char[] a = new char[N], b = new char[N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        String s=input.next();
        for (int i = 1; i <= n; i++)
            a[i] = s.charAt(i-1);
        String s1=input.next();
        for (int i = 1; i <= m; i++)
            b[i] = s1.charAt(i-1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (a[i] == b[j])
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        }
        System.out.println(f[n][m]);
    }
}

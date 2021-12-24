package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 数字三角形 {
    public static int N = 510;
    public static int[][] a = new int[N][N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = input.nextInt();
            }
        }
        //初始化，因为数据中有负数，所以初始的0不符合条件
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        f[1][1] = a[1][1];
        //从第二行第一列开始
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + a[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        //遍历最后一行，因为最后一行的所有数据都有可能
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, f[n][i]);
        }
        System.out.println(max);
    }
}

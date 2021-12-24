package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 最短Hamilton {
    public static int N = 21, M = 1 << N;
    public static int[][] dp = new int[M][N];
    public static int[][] w = new int[N][N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = input.nextInt();
            }
        }
        for(int i=0;i<M; i++){
            Arrays.fill(dp[i],0x3f3f3f3f);
        }
        dp[1][0]=0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                //j在该路径内
                if (((i >> j) & 1) != 0) {
                    for (int k = 0; k < n; k++) {
                        //k在该路径内
                        if (((i - (1 << j) >> k) & 1)!= 0) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - (1 << j)][k] +w[k][j]);

                        }
                    }
                }
            }
        }
        System.out.println(dp[(1 << n) - 1][n - 1]);
    }
}

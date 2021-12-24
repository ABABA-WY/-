package 动态规划;

import java.util.Map;
import java.util.Scanner;

public class 石子合并 {
    public static int N = 310;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] s = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = input.nextInt();
            s[i] = s[i] + s[i - 1];
        }
        //先枚举整个区间的长度
        //区间长度为1的话，就为本身，没必要枚举
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i, r = i + len - 1;
                f[i][r]=Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    f[i][r] = Math.min(f[i][r], f[i][k] + f[k + 1][r] + s[r] - s[i - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}

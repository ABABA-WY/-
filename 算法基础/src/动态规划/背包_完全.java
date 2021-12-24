package 动态规划;

import java.util.Scanner;

public class 背包_完全 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//n件物品
        int m = input.nextInt();//背包容量
        int[] w = new int[n + 1];//物品价值
        int[] v = new int[n + 1];//物品体积
        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = input.nextInt();
            w[i] = input.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
            System.out.println(f[m]);
        }
    }
}

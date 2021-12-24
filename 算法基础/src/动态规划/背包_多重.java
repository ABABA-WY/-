package 动态规划;

import java.util.Scanner;

public class 背包_多重 {
    public static int N = 25000, M = 2010;
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int cnt = 0;//所分成的份数
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int s = input.nextInt();
            int k = 1;
            //二进制计数
            while (k <= s) {
                cnt++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k *= 2;
            }
            //还有剩余
            if (s > 0) {
                cnt++;
                v[cnt] = s * a;
                w[cnt] = s * b;
            }
        }
        //最后分出来的份数
        n = cnt;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }
}

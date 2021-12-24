package 树与图;

import java.util.Scanner;

public class Floyd {
    public static final int N = 210;
    public static final int maxNum = 0x3f3f3f3f;
    public static int n, m, Q;
    public static int[][] d = new int[N][N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        Q = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = maxNum;
            }
        }
        while (m-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int w = input.nextInt();
            d[a][b] = Math.min(d[a][b], w);
        }
        floyd();
        while (Q-- > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (d[x][y] > maxNum / 2)
                System.out.println("impossible");
            else
                System.out.println(d[x][y]);
        }
    }

    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}

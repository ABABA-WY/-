import java.util.Scanner;

//二维前缀和
/*
左上角的坐标为x-r，y-r
右下角的坐标为x+r，y+r
同时要注意边界问题
只需要计算出这个区域内的面积便能得出答案
想成一个简单的长方形便可
不必想成一个圆形，圆形十分复杂
* */
public class CSP_202104_2 {
    public static int n;
    public static int L;
    public static int r;
    public static int t;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        L = input.nextInt();
        r = input.nextInt();
        t = input.nextInt();
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = input.nextInt();
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + x;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isBlack(i, j))
                    ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean isBlack(int x, int y) {
        int maxx = Math.min(x + r, n);
        int maxy = Math.min(y + r, n);
        int minx = Math.max(x - r, 1);
        int miny = Math.max(y - r, 1);
        int res = dp[maxx][maxy] - dp[minx - 1][maxy] - dp[maxx][miny - 1] + dp[minx - 1][miny - 1];
        double cnt = (maxx - minx + 1) * (maxy - miny + 1);
        return (double) res / cnt <= t;
    }
}

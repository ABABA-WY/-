package 动态规划;

import java.util.Arrays;
import java.util.Scanner;

public class 记忆化搜索 {
    public static int[][] h;
    public static int[][] find;
    public static int R, C;
    public static int[] dir = {1, 0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        R = input.nextInt();
        C = input.nextInt();
        h = new int[R + 1][C + 1];
        find = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            Arrays.fill(find[i], -1);
            for (int j = 1; j <= C; j++) {
                h[i][j] = input.nextInt();
            }
        }
        int res = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                res = Math.max(res, dp(i, j));
            }
        }
        System.out.println(res);
    }

    public static int dp(int x, int y) {
        //已经递归寻找过，不用再递归
        if (find[x][y] != -1) return find[x][y];
        //最少步数为1
        find[x][y] = 1;
        //遍历四个方向
        for (int k = 0; k < 4; k++) {
            int a = x + dir[k];
            int b = y + dir[k + 1];
            if (a >= 1 && a <= R && b >= 1 && b <= C && h[a][b] < h[x][y])
                find[x][y] = Math.max(find[x][y], dp(a, b) + 1);
        }
        return find[x][y];
    }
}

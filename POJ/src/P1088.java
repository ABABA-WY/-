import java.util.Scanner;

public class P1088 {
    public static int n, m;
    public static int[] dir = {1, 0, -1, 0, 1};
    public static int[][] g;
    public static int[][] maxLen = new int[105][105];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        g = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                g[i][j] = input.nextInt();
                maxLen[i][j] = 0;
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        //已经被搜索过
        if (maxLen[x][y] != 0) {
            return maxLen[x][y];
        }
        maxLen[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i];
            int yy = y + dir[i + 1];
            if (1 <= xx && xx <= m && 1 <= yy && yy <= n) {
                if (g[xx][yy] < g[x][y]) {
                    maxLen[x][y] = Math.max(dfs(xx, yy) + 1, maxLen[x][y]);
                }
            }
        }
        return maxLen[x][y];
    }

}

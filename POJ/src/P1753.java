import java.util.Scanner;

public class P1753 {
    public static int[][] ans = new int[4][4];
    public static int cnt = Integer.MAX_VALUE;
    public static boolean flag=false;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String s = input.nextLine();
            for (int j = 0; j < 4; j++) {
                if (s.charAt(j) == 'w')
                    ans[i][j] = 1;
            }
        }
        dfs(0, 0, 0);
        if(flag)
            System.out.print(cnt);
        else
            System.out.println("Impossible");
    }

    public static void dfs(int x, int y, int n) {
        if (judge()) {
            cnt = Math.min(cnt, n);
            flag=true;
            return;
        }
        if (x >= 4 || y >= 4) return;
        int nx = (x + 1) % 4;
        int ny = y + (x + 1) / 4;
        change(x, y);
        dfs(nx, ny, n + 1);
        change(x, y);
        dfs(nx, ny, n);
    }

    public static boolean judge() {
        int ix = 0, iy = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (ans[i][j] == 1) ix++;
                else iy++;
            }
        }
        return (ix == 0 || iy == 0);
    }

    public static void change(int x, int y) {
        ans[x][y] ^= 1;
        if (x + 1 < 4)  ans[x + 1][y] ^= 1;
        if (x - 1 >= 0) ans[x - 1][y] ^= 1;
        if (y + 1 < 4)  ans[x][y + 1] ^= 1;
        if (y - 1 >= 0) ans[x][y - 1] ^= 1;
    }
}

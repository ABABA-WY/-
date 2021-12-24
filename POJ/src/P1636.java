import java.util.Scanner;

public class P1636 {
    public static int size = 210;
    public static int r, m, asize, bsize;
    public static boolean[][] visit = new boolean[2][size];//两个监狱的人是否被访问过
    public static boolean[][] dp = new boolean[size][size];//监狱1交换i人与监狱2交换j人是否可行
    public static boolean[][] map;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while (n-- > 0) {
            visit = new boolean[2][size];
            dp = new boolean[size][size];
            map = new boolean[size][size];
            m = input.nextInt();
            r = input.nextInt();
            for (int i = 0; i < r; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                map[a][b] = true;
            }
            //监狱1
            for (int i = 1; i <= m; i++) {
                if (visit[0][i]) continue;
                asize = 0;
                bsize = 0;
                dfs(0, i);
                kpack();
            }
            //监狱2
            for (int i = 1; i <= m; i++) {
                if (visit[1][i]) continue;
                asize = 0;
                bsize = 0;
                dfs(1, i);
                kpack();
            }
            for(int i = m / 2; i >= 0; i--){
                if(dp[i][i]){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    //将有冲突的连在一起
    public static void dfs(int v, int id) {
        visit[v][id] = true;
        if (v == 0) {
            asize++;
            for (int i = 1; i <= m; i++) {
                if (map[id][i] && !visit[1][i])
                    dfs(1, i);
            }
        } else {
            bsize++;
            for (int i = 1; i <= m; i++) {
                if (map[i][id] && !visit[0][i]) {
                    dfs(0, i);
                }
            }
        }
    }
    public static void kpack(){
        dp[0][0] = true;
        for (int i = m / 2; i >= asize; i--) {
            for (int j = m / 2; j >= bsize; j--) {
                if (dp[i][j] || dp[i - asize][j - bsize]) {
                    dp[i][j] = true;
                }
            }
        }
    }

}

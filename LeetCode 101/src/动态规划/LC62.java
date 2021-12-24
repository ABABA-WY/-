package 动态规划;

public class LC62 {
    //dfs超时
/*    public int uniquePaths(int m, int n) {
        int res=0;
        res+=dfs(m,n,0,0);
        return res;
    }
    public int dfs(int m,int n,int x,int y){
        if(x==m&&y==n){
            return 1;
        }
        if(x<1||x>m||y < 1 || y > n){
            return 0;
        }
        return dfs(m,n,x+1,y)+dfs(m, n, x, y+1);
    }*/

    public int uniquePaths(int m, int n) {
        int res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;//边界
        for (int i = 0; i < n; i++) dp[0][n] = 1;//边界

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

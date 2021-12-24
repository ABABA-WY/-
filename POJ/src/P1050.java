import java.util.Scanner;

public class P1050 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] dp=new int[n+1][n+1];
        int[][] g=new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {
                g[i][j] = input.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+g[i][j];
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j = 1; j <=n; j++){
                for(int x=1;x<=i; x++){
                    for (int y = 1; y <= j; y++) {
                        ans=Math.max(ans, dp[i][j]-dp[x-1][j]-dp[i][y-1]+dp[x-1][y-1]);
                    }
                }
            }
        }
        System.out.println(ans);
    }

}

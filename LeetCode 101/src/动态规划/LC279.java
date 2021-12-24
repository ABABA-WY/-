package 动态规划;

import java.util.Scanner;

public class LC279 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(new LC279().numSquares(n));
    }
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n; i++){
            dp[i]=i;
            for (int j = 1; i-j*j>=0; j++) {
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

}

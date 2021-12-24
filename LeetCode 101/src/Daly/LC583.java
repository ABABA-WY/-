package Daly;

public class LC583 {
    public static void main(String[] args) {
        String word1="sea";
        String word2 = "eat";
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][]dp=new int[m+1][n+1];
        for(int i=1;i<=m; i++){
            dp[i][0]=i;
        }
        for(int j = 1; j <= n; j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            char a=word1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char b = word2.charAt(j-1);
                if(a==b){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
}

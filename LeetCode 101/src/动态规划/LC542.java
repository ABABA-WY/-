package 动态规划;

public class LC542 {
    public static void main(String[] args) {
        int[][] mat={{0,0,0},{0,1,0},{1,1,1}};
        int[][] res=new LC542().updateMatrix(mat);
        for(int i = 0; i < mat.length; i++){
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n=mat[0].length;
        int[][] dp=new int [m][n];
        for(int i=0;i<m; i++){
            for (int j = 0; j < n; j++) {
                if(i==0&&j == 0){
                    if(mat[i][j] == 0){
                        dp[i][j]=0;
                        dp[i+1][j] = 0;
                        dp[i][j+1]=0;
                    }
                }
                else if(i==0){

                }
            }
        }
        return dp;
    }
}

package 动态规划;

import java.util.Scanner;

public class 背包_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//n件物品
        int m = input.nextInt();//背包容量
        int[] w=new int[n+1];//物品价值
        int[] v = new int[n+1];//物品体积
        int[][] f=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            v[i] = input.nextInt();
            w[i] = input.nextInt();
        }
        for(int i=1;i <= n; i++){
            for(int j=1;j<=m; j++){
                f[i][j]=f[i-1][j];
                if(j>=v[i])
                    f[i][j] = Math.max(f[i][j],f[i-1][j-v[i]]+w[i]);
            }
        }
        System.out.println(f[n][m]);
    }

}

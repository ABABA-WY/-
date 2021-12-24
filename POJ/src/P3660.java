import java.util.Scanner;

public class P3660 {
    public static int m,n;
    public static boolean[][] v;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        v = new boolean[n+1][n+1];
        for(int i = 1;i <= m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            v[a][b] = true;
        }
        floyd();
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (v[i][j] ||v[j][i]) {
                    cnt++;
                }
            }
            if (cnt == n-1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void floyd(){
        for(int k = 1;k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(v[i][j] || (v[i][k]&&v[k][j])){
                        v[i][j] = true;
                    }
                }
            }
        }
    }
}

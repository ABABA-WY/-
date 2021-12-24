import java.util.Scanner;

public class CSP_2019_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] g=new int[n+1];
        int count=1;
        for(int i=1;i<=n;i++){
            int a=input.nextInt();
            if(a!=g[count-1])
                g[count++] = a;
        }
        int[] res=new int[10010];
        for(int i=1;i<n; i++){
            if(g[i-1]>g[i]&&g[i] < g[i+1])
                res[g[i]]--;
            else if(g[i-1]<g[i]&&g[i] > g[i+1]){
                res[g[i]]++;
            }
        }
        int sum=0;
        int ans=0;
        for(int i=10000;i>0;i--){
            sum+=res[i];
            ans=Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}

import java.util.Scanner;

public class CSP_201703_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] g=new int[n+1];//整个队列
        int[] f = new int[n+1];//移动后每个人的坐标；
        for(int i=1;i<=n; i++) {
            g[i] = i;
            f[i]=i;
        }
        while(m-->0){
            int a=input.nextInt();
            int b = input.nextInt();
            int i=f[a];
            if(b>0){
                for(int j=i;j<i+b; j++) {
                    g[j] = g[j + 1];
                    f[g[j]]=j;
                }
            }
            else if(b<0){
                for(int j=i;j>i+b;j--){
                    g[j]=g[j-1];
                    f[g[j]]=j;
                }
            }
            g[i+b]=a;
            f[a]=i+b;
            /*for(int k=1;k<=n; k++){
                System.out.print(g[k]+" ");
            }
            System.out.println();*/
        }
        for(int k=1;k<=n; k++){
            System.out.print(g[k]+" ");
        }
    }
}

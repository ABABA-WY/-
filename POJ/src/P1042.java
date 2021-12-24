import java.util.Scanner;

public class P1042 {
    public static int n;
    public static int h;
    public static int[] f;
    public static int[] d;
    public static int[] t;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        h = input.nextInt();
        f=new int[n+1];
        d = new int[n+1];
        t = new int[n];
        //存放鱼的数量和时间
        int [][] ans=new int[n+1][n+1];
        for(int i=1;i<=n; i++){
            f[i] = input.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            d[i] = input.nextInt();
        }
        for (int i = 1; i < n; i++) {
            t[i]=input.nextInt();
        }
        h*=12;
        for(int i = 1; i <= n; i++){
            int[] ft=new int[n+1];
            int j;
            for(j=1; j<=i; j++)
                ft[j]=f[j];//存储最初钓鱼量
            int ht=h;
            for(j=1; j<i; j++)
                ht-=t[j];//把走向下一个湖的时间减去
            int k,emp=1;
            while(ht>0&&emp<=i)
            {
                k=1;
                for(j=emp; j<=i; j++)
                    if(ft[j]>ft[k])
                        k=j;
                ans[i][0]+=ft[k];//加上最大的钓鱼量
                ++ans[i][k];//在这个湖里钓鱼的时间加一次
                --ht;//拥有时间减去一次
                ft[k]-=d[k];//鱼量减一次
                ft[k]=ft[k]>0?ft[k]:0;//如果目前所剩鱼量小于0，赋值为0
                for(j=emp; j<=i; j++)
                {
                    if(ft[j]==0)
                        ++emp;//统计有几个湖已经没有鱼
                    else
                        break;
                }
            }
            if(ht>0)//如果还有时间就把鱼量加上
                ans[i][1]+=ht;
        }


        int a=1;
        for(int i=2; i<=n; i++)//寻找最大值
            if(ans[i][0]>ans[a][0])
                a=i;
        for(int i=1; i<=n; i++)//输出每个湖所呆的时间
        {
            System.out.print(ans[a][i]*5);
            if(i!=n)
                System.out.print(", ");
        }
        System.out.print("\nNumber of fish expected: "+ans[a][0]+"\n");


    }
}

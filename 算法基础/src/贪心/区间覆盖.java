package 贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 区间覆盖 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int r = input.nextInt();
        int n = input.nextInt();
        List<int[]> ans=new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            ans.add(new int[]{a,b});
        }
        Collections.sort(ans,(a,b)->{
            return a[0]-b[0];
        });
        int res=0;
        boolean f=false;
        for(int i = 0; i < n; i++){
            int j=i;
            int maxr=Integer.MIN_VALUE;
            //找到所有左端点比起点小的区间的最大值
            while (j<n&&ans.get(j)[0]<=l){
                maxr=Math.max(maxr, ans.get(j)[1]);
                j++;
            }
            //找不到任何点
            if(j==i){
                System.out.println(-1);
                return;
            }
            res++;
            if(maxr>=r) {
                f=true;
                break;
            }
            //将区间左端点变成当前所能到达的最大右端点
            l=maxr;
            i=j-1;
        }
        if(!f) res=-1;
        System.out.println(res);
    }
}

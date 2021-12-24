package 贪心;

import java.util.*;

public class 区间分组 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            ans.add(new int[]{l, r});
        }
        //左端点
        Collections.sort(ans, (a, b) -> {
            return a[0] - b[0];
        });
        int r=0;
        int res=1;
        for(int i=0;i<n; i++){
            if(ans.get(i)[0]>r){
                res++;
            }
            r=Math.max(r,ans.get(i)[1]);
        }
        System.out.println(res);
    }
}

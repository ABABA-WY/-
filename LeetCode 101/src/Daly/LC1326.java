package Daly;

public class LC1326 {
    public static void main(String[] args) {
        int n =7;
        int[] ranges={1,2,1,0,2,1,0,1};
        System.out.println(new LC1326().minTaps(n,ranges));
    }
    public int minTaps(int n, int[] ranges) {
        int[] ans=new int[n];
        for (int i = 0; i < ranges.length; i++) {
            int l=Math.max(i-ranges[i],0);
            int r = Math.min(i+ranges[i], n);
            for(int j=l;j<r; j++){
                ans[j]=Math.max(ans[j],r);
            }
        }
        int cur=0,cnt=0;
        while(cur<n){
            if(ans[cur]==0)
                return -1;
            cur=ans[cur];
            cnt++;
        }
        return cnt;
    }
}

package Competition;

public class LC5939 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        long[] sum =new long[n+1];
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+nums[i-1];
        }
        for(int i=0;i<n;i++){
            if(i-k<0||i+k>=n){
                ans[i]=-1;
                continue;
            }
            int avg =(int)Math.ceil((sum[i+k+1]-sum[i-k])/(2*k+1));
            ans[i]=avg;
        }
        return ans;
    }
}

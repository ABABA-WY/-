package Competition;

import java.util.Arrays;

public class LC5899 {
    public static void main(String[] args) {
        int[][] events={{1,3,2},{4,5,2},{2,4,3}};
        System.out.println(new LC5899().maxTwoEvents(events));
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int[] dp=new int[events.length+1];
        dp[0]=events[0][2];
        for (int i = 0; i < events.length-1; i++) {
            System.out.println(events[i][2]);
            if(events[i][1] < events[i+1][0]){
                dp[i+1]=dp[i]+events[i+1][2];
            }
            else if(i>=2&&events[i-1][1]<=events[i+1][0]){
                dp[i+1] = events[i+1][2] + dp[i-1];
            }
            else  {
                dp[i+1]=Math.max(dp[i],events[i+1][2]);
            }
        }
        return dp[events.length - 1];
    }
}

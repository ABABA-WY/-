package Daly;

import java.util.Arrays;

public class LC517 {
    public static void main(String[] args) {

    }
    public int findMinMoves(int[] machines) {
        int m= Arrays.stream(machines).sum();
        int n=machines.length;
        if(m%n!=0)
            return -1;
        int avg=m/n;
        int ans=0;
        int sum=0;
        for(int num:machines){
            num-=avg;
            sum+=num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}

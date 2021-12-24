package 数学;

import java.util.Arrays;
import java.util.Random;

public class LC528 {

    public static void main(String[] args) {

    }
    private int[] sum;
    public LC528(int[] nums){
        sum = new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i-1]+sum[i-1];
        }
    }
    public int pickIndex() {
        int n=sum.length;
        int t=(int)(Math.random()*sum[n-1])+1;
        int l=1,r=n-1;
        while (l < r) {
            int mid=(l+r)/2;
            if(sum[mid]==t)  break;
            else if(sum[mid] > t){
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return l;
    }
}

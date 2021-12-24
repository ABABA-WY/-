package lable6;

public class Lc740 {
    public static void main(String[] args) {
        int[] nums={2,2,3,3,3,4};
        if(nums.length ==0||nums==null)
            return;
        if(nums.length == 1)
            return;
        int max=nums[0];
        for(int i=0;i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] a=new int[max+1];

        for (int temp:nums) {
            a[temp]++;
        }
        int[] dp=new int[max+1];
        dp[1]=a[1]*1;
        dp[2] = a[2] * 2;
        for(int i=2;i<=max; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+i*a[i]);
        }
        System.out.println(dp[max]);
    }
}

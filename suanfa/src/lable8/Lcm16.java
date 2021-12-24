package lable8;

public class Lcm16 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int pre=0;
        int maxnum=nums[0];
        for(int x:nums){
            pre=Math.max(pre+x,x);
            maxnum=Math.max(pre,maxnum);
        }
        System.out.println(maxnum);
    }
}

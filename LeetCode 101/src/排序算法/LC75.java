package 排序算法;

import java.util.Arrays;

public class LC75 {
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        new LC75().sortColors(nums);
    }
    public void sortColors(int[] nums) {
        int[] ans=new int[nums.length];
        int one=0;
        int zero=0;
        int two = 0;
        for (int i = 0; i < ans.length; i++) {
            int temp = nums[i];
            ans[two++]=2;
            if(temp<=1){
                ans[one++]=1;
            }
            if(temp==0){
                ans[zero++]=0;
            }
        }
        nums=Arrays.copyOf(ans, ans.length);
        for (int x:nums)
            System.out.println(x);
    }
}

package 贪心;

public class LC665 {
    public static void main(String[] args) {
        int [] nums = {4,2,3,1};
        if(nums.length <=1)return ;
        boolean flag=nums[0]<nums[1]?true : false;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] >nums[i+1]){
                if(flag){
                    if(nums[i+1]>=nums[i-1]){
                        nums[i]=nums[i+1];
                    }
                    else {
                        nums[i+1] = nums[i];
                    }
                    flag=false;
                }
                else
                    return;
            }
        }
    }
}

package 数据结构;

public class LC287 {
    public static void main(String[] args) {
        int[] nums={3,1,3,4,2};
        System.out.println(new LC287().findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        int pre1=0;
        int pre2=slow;
        while (pre1 != pre2) {
            pre1=nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}

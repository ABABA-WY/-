package 排序算法;

import java.util.Arrays;

public class LC215 {
    public static void main(String[] args) {
        LC215 test=new LC215();
        int [] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(test.findKthLargest(nums,k));
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

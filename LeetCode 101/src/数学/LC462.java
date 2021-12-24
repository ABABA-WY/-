package 数学;

import java.util.Arrays;

public class LC462 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new LC462().minMoves2(nums));
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int x:nums){
            count+=Math.abs(nums[nums.length/2]-x);
        }
        return count;
    }
}

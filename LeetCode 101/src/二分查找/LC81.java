package 二分查找;

import java.util.Arrays;
import java.util.OptionalInt;

public class LC81 {
    public static void main(String[] args) {
        int[] nums={2,5,6,0,0,1,2};
        int target=0;
        int left = 0;
        int right=nums.length - 1;
        int mid;
        while (left < right) {

            mid=(left + right)/2;
            if(nums[mid] ==target) return;
            if(nums[left]==nums[mid]&&nums[right]==nums[mid]){
                left++;
                right--;
            }
            else if(nums[mid] >= nums[left]){
                if(nums[mid]>target){
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
            else {
                if(nums[mid]<target&&target<nums[nums.length - 1]){
                    left=mid+1;
                }
                else right=mid-1;
            }
        }
        System.out.println();
    }
}

package lable9;

import java.util.Arrays;

public class LC1679 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int k=5;
        Arrays.sort(nums);
        int left=0,right = nums.length - 1;
        int count=0;
        while (left < right) {
            if (nums[left] +nums[right] < k ){
                left++;
            }
            else if(nums[left]+nums[right] > k){
                right--;
            }
            else{
                count++;
                right--;
                left++;
            }
        }
        System.out.println(count);
    }
}

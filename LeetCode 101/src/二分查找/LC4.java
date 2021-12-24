package 二分查找;

import java.util.Arrays;

public class LC4 {
    public static void main(String[] args) {
        LC4 test=new LC4();
        int[] nums1={1,3};
        int[] nums2={2};
        double result= test.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        int mid=(nums.length-1)/2;
        if(nums.length%2==0){
            return (double) (nums[mid]+nums[mid+1])/2;
        }
        else {
            return (double) nums[mid];
        }
    }
}

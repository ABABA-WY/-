package 二分查找;

public class LC540 {
    public static void main(String[] args) {
        int [] nums = {3,3,7};
        int left=0,right = nums.length-1;
        int mid;
        while (left < right) {
            mid=left + (right-left)/2;
            if(mid%2==1) mid=mid-1;
            if(nums[mid]==nums[mid+1]){
                left=mid+2;
            }
            else
                right=mid;
        }
        System.out.println(nums[right]);
    }
}

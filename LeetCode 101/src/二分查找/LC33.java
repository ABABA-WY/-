package 二分查找;

public class LC33 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int target=3;
        System.out.println(new LC33().search(nums,target));
    }
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        int mid=l+(r-l)/2;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]>target){
                if(target<=nums[r]&&nums[mid]> nums[r]){
                    l=mid+1;
                }
                else
                    r=mid-1;
            }
            else{
                if(target>=nums[l]&&nums[l]>nums[mid]){
                    r=mid-1;
                }
                else
                    l = mid + 1;
            }

        }
        return nums[mid]==target?mid:-1;
    }
}

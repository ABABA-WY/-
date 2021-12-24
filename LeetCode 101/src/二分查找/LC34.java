package 二分查找;

public class LC34 {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int [] ans={-1,-1};
        int l=0,r= nums.length-1;
        int mid;
       while(l<r){
           mid=(r+l)/2;
           if(nums[mid] >= target) r=mid;
           else l=mid+1;
       }
       if(nums[r]!=target) return;
       int L=r;
       l=0;
       r=nums.length-1;
        while(l<r){
            mid=(r+l+1)/2;
            if(nums[mid] <= target) l=mid;
            else r=mid-1;
        }
        return;

    }
}

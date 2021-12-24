package 二分;

public class LC162 {
    public static void main(String[] args) {
        int[] nums={1,2};
        System.out.println(new LC162().findPeakElement(nums));
    }
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length - 1;
        int ans=-1;
        while (left <= right) {
            int mid = left + right>>1;
            if(compare(nums,mid-1,mid)<0&&compare(nums, mid , mid+1) > 0){
                ans=mid;
                break;
            }
            if(compare(nums,mid-1,mid)>0)
                right=mid-1;
            else
                left=mid+1;
        }
        return ans;
    }
    public int compare(int[] nums,int idx1,int idx2){
        int[] num1=get(nums, idx1);
        int[] num2=get(nums, idx2);
        if(num1[0]!=num2[0] ){
            return num1[0]>num2[0]?1:-1;
        }
        if(num1[1] == num2[1])
            return 0;
        return num1[1]>num2[1]?1:-1;
    }
    public int[] get(int[] nums,int idx){
        if(idx < 0 || idx >= nums.length){
            return new int[]{0,0};
        }
        return new int[] {1,nums[idx]};
    }
}

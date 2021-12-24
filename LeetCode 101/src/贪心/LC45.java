package 贪心;

public class LC45 {
    public static void main(String[] args) {
        int[] nums={2,3,0,1,4};
        System.out.println(new LC45().jump(nums));
    }
    public int jump(int[] nums) {
        int n=nums.length-1;
        int max_far=0;
        int step=0;
        int end=0;
        for (int i = 0; i < n; i++) {
            max_far=Math.max(max_far,i+nums[i]);
            if(i==end){
                end=max_far;
                step++;
            }
        }
        return step;
    }
}

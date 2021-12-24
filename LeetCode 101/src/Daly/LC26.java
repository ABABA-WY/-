package Daly;

public class LC26 {
    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(new LC26().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int res=0;
        int i=0,j=0;
        while(i < nums.length){
            while(nums[i]!=nums[j]){
                nums[++j]=nums[i];
            }
            i++;
        }
        return j+1;
    }
}

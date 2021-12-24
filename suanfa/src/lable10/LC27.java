package lable10;

public class LC27 {
    public static void main(String[] args) {
        int val=3;
        int [] nums={3,2,2,3};
        int left=0,right = 0;
        for (right= 0; right < nums.length; right++) {
            if(nums[right]!=val){
                nums[left++]=nums[right];
            }
        }
        System.out.println(left);
        for (int x:nums)
            System.out.println(x);
    }
}

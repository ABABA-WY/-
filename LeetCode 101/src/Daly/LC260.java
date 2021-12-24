package Daly;

public class LC260 {
    public int[] singleNumber(int[] nums) {
        int[] ans=new int[2];
        int xor=0;
        for(int num:nums){
            xor^=num;
        }
        int a=xor&(~xor);
        for (int num : nums) {
            if((num&a) == 0){
                ans[0]^=num;
            }
            else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}

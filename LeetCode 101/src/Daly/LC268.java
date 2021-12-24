package Daly;

import java.util.Arrays;

public class LC268 {
    //排序
/*    public int missingNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(i!=nums[i])
                return i;
        }
        return n;
    }*/
    //位运算
    public int missingNumber(int[] nums) {
        int xor=0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            xor^=nums[i];
        }
        for(int i = 0; i <= n; i++){
            xor^=i;
        }
        return xor;
    }
}

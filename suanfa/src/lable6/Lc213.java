package lable6;

import java.util.Arrays;

public class Lc213 {
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        if(nums.length ==0||nums==null)
            return;
        if(nums.length == 1)
            return;

    }
    private int myRob(int[] nums){
        int pre=0,cur = 0,tmp;
        for(int num:nums){
            tmp=cur;
            cur=Math.max(pre+num,cur);
            pre=tmp;
        }
        return cur;
    }
}

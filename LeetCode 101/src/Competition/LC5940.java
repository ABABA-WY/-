package Competition;

import java.util.Arrays;

public class LC5940 {
    public int minimumDeletions(int[] nums) {
        int[] clones = nums.clone();
        int ans=0;
        int n =nums.length;
        Arrays.sort(clones);
        int a = clones[0];
        int b= clones[n-1];
        int l=0,r = n-1;
        boolean flag=false;
        int pre=0;
        for(int i = 0; i < n; i++){
            if (nums[i] == a) {
                if(!flag){
                    pre = i;
                    flag = true;
                }
                else{
                    ans=Math.min(Math.min(i+1,pre+1+n-i),n-pre);
                    break;
                }
            }
            if(nums[i] == b){
                if(!flag){
                    pre = i;
                    flag = true;
                }
                else{
                    ans=Math.min(Math.min(i+1,pre+1+n-i),n-pre);
                    break;
                }
            }
        }
        return ans;
    }
}

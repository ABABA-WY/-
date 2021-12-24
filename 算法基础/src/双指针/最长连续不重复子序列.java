package 双指针;

import java.util.Arrays;

public class 最长连续不重复子序列 {
    public static void main(String[] args) {
        int[] nums={1,2,2,3,5};
        int n=nums.length;

        int[] s=new int[10000];
        int res=0;
        for (int i = 0,j=0; i < n; i++) {
            s[nums[i]]++;
            while(s[nums[i]]>1){
                s[nums[j]]--;
                j++;
            }
            res=Math.max(res, i-j+1);
        }
        System.out.println(res);
    }
}

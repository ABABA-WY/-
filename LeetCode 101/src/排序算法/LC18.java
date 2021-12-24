package 排序算法;

import java.util.*;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l=j+1,r= nums.length-1;
                while(l<r){
                    if(nums[i]+nums[j]+nums[l]+nums[r]<target){
                        l++;
                    } else if (nums[i]+nums[j]+nums[l]+nums[r]>target) {
                        r--;
                    }
                    else {
                        List<Integer> ans=Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                        res.add(ans);
                        while(l<r&&nums[r-1]==nums[r]) r--;
                        while(l<r&&nums[l+1]==nums[l]) l++;
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}

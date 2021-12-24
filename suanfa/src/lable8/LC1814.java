package lable8;

import java.util.*;

public class LC1814 {
    public static void main(String[] args) {
        int [] nums={1,2,1};
        int [] nums1= Arrays.copyOf(nums,nums.length);
        int [] rev=new int[nums.length];
        Map<Integer,Integer> ans=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            rev[i]=0;
            while(nums1[i]>0) {
                rev[i] = rev[i] * 10 + nums1[i] % 10;
                nums1[i] /= 10;
            }
            int key=nums[i]-rev[i];
            ans.put(key,ans.getOrDefault(key,0)+1);
        }
        long count=0;
        for(int key:ans.keySet()){
            long time=ans.get(key);
            count+=time*(time-1)/2;
        }
        int mod = (int)1e9+7;
        System.out.println(count%mod);
        for(int x:rev)
            System.out.println(x);
    }
}

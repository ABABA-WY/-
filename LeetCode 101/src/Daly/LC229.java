package Daly;

import java.util.*;

public class LC229 {
    //Map方法
    //时间O（n） 空间O（n）；但其余操作会花更多时间。
//    public List<Integer> majorityElement(int[] nums) {
//        int n = nums.length;
//        HashMap<Integer, Integer> ans =new HashMap<>();
//        TreeSet<Integer> s= new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
//            if(ans.get(nums[i])>n/3)
//                s.add(nums[i]);
//        }
//        return new LinkedList<>(s) ;
//    }

    //摩尔统计法
    //时间o(n),空间O(1);
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        for (int x : nums) {
            if (c1 != 0 && a == x) c1++;
            else if (c2 != 0 && b == x) c2++;
            else if (c1 == 0 && ++c1>=0) a = x;
            else if (c2 == 0 && ++c2>=0) b = x;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if(a==x) c1++;
            else if(b==x) c2++;
        }
        List<Integer> ans=new ArrayList<Integer>();
        if(c1>n/3)
            ans.add(a);
        if(c2>n / 3)
            ans.add(b);
        return ans;
    }

}

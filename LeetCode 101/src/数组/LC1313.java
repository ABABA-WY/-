package 数组;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
public class LC1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans=new LinkedList<>();
        for(int i=0;i< nums.length;i+=2){
            for(int j=0;j < nums[i]; j ++){
                ans.add(nums[i+1]);
            }
        }
        int[] res=new int[ans.size()];
        for (int i = 0; i <ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}

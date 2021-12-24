package 区间优化;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class 区间合并 {
    public static void main(String[] args) {
        int[][] intervals={{1,4},{2,3},{8,10},{9,15},{19,20}};
        int[][] res=new 区间合并().merge(intervals);
        for(int[]nums:res){
            for(int num:nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ans.add(intervals[0]);
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=ans.get(count)[1]){
                ans.get(count)[1]=Math.max(intervals[i][1],ans.get(count)[1]);
            }
            else {
                ans.add(intervals[i]);
                count++;
            }

        }

        return ans.toArray(new int[ans.size()][]);
    }
}

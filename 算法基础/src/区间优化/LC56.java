package 区间优化;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ans=new LinkedList<>();
        ans.add(intervals[0]);
        int len=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<ans.get(len)[1]){
                ans.get(len)[1]=Math.max(ans.get(len)[1],intervals[i][1]);
            }
            else{
                ans.add(intervals[i]);
                len++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}



package 贪心;

import java.util.Arrays;

public class LC435 {
    public static void main(String[] args) {
        int[][] intervals={{1,2},{1,3},{2,3},{3,4}};
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int pre=intervals[0][1];
        for(int i=1;i< intervals.length;i++){
            if(intervals[i][0]<pre)
                count++;
            else
                pre=intervals[i][1];
        }
        System.out.println(count);
    }
}
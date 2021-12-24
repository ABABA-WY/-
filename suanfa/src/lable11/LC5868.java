package lable11;

import java.util.*;

public class LC5868 {
    public static void main(String[] args) {
        int[][] rectangles={{4,8},{3,6},{15,30}};
        System.out.println(new LC5868().interchangeableRectangles(rectangles));
    }
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long> ans = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            double a=(double) rectangles[i][0]/rectangles[i][1];
            ans.put(a, ans.getOrDefault(a,(long)0)+1);
        }
        long count=0;
        for(double x: ans.keySet()){
            System.out.println(x);
            long y = ans.get(x);
            System.out.println(y);
            count=count+y*(y-1)/2;
        }
        return count;
    }
}

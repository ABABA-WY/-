package 贪心;

import java.util.Arrays;

public class LC452 {
    public static void main(String[] args) {
        int [][] points={{10,16},{2,8},{1,6},{7,12}};
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int pre=points[0][1];
        int count=0;
        for (int i = 1; i < points.length; i++) {
            if(pre>=points[i][0])  continue;
            count++;
            pre = points[i][1];
        }
        System.out.println(count);
    }
}

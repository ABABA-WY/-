package 数据结构;

import java.util.*;

public class LC149 {
    public static void main(String[] args) {
        int[][] points ={{1,1},{2,2},{3,3}};
        System.out.println(new LC149().maxPoints(points));
    }
    public int maxPoints(int[][] points) {
        if(points.length<=2){
            return points.length;
        }
        int ret = 0;
        for(int i = 0; i < points.length-1; i++){
            if(ret>=points.length-1||ret>points.length/2){
                return ret;
            }
            Map<Integer,Integer> ans = new HashMap<>();
            for(int j=i+1; j < points.length; j++) {
                int y = points[i][1] - points[j][1];
                int x = points[i][0] - points[j][0];
                if (y == 0) {
                    x = 1;
                } else if (x == 0) {
                    y = 1;
                } else {
                    if (y < 0) {
                        y = -y;
                        x = -x;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x/=gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                ans.put(key,ans.getOrDefault(key,0)+1);
            }
            int max=0;
            for(Map.Entry<Integer, Integer> entry : ans.entrySet()){
                int num=entry.getValue();
                max=Math.max(max, num+1);
            }
            ret=Math.max(max,ret);
        }

        return ret;
    }
    public int gcd(int a, int b) {
        return b!=0?gcd(b,a%b):a;
    }

}

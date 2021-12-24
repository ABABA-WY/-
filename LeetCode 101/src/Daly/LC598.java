package Daly;

public class LC598 {
    public int maxCount(int m, int n, int[][] ops) {
        int minm=m;
        int minn=n;
        for(int[] ans:ops){
            minm=Math.min(ans[0],minm);
            minn=Math.min(ans[1],minn);
        }
        return minm*minn;
    }
}

package lable4;

public class Lc746 {
    public static void main(String[] args) {
        Lc746 test=new Lc746();
        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(test.minCostClimbingStairs(cost));

    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int down=0;
        int downDown=0;
        for(int i=2;i<=n;i++){
            int cur=Math.min(cost[i-1]+down,cost[i-2]+downDown);
            downDown=down;
            down=cur;
        }
        return down;
    }
}

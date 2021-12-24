package 贪心;

import java.util.PriorityQueue;

public class LC1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //用来存放用去的砖头,降序排序
        PriorityQueue<Integer> ans = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int sub = heights[i] - heights[i - 1];
            //后面的楼比前面的高
            if (sub > 0) {
                //先消耗砖头
                ans.add(sub);
                bricks -= sub;
                if (bricks < 0) {
                    //砖头不够，梯子来凑
                    if (ladders > 0) {
                        ladders--;
                        bricks += ans.poll();
                    }
                    //梯子不够，回家吃饭
                    else
                        return i - 1;
                }
            }
        }
        //到达最后一栋楼
        return heights.length - 1;
    }
}

package 图论;

public class XT22_1 {

    public static int N = 1000;//最多事件、人数
    public static int[][] cost = new int[N][N];//把工作j分配给第i个人的成本
    public static boolean[] vis = new boolean[N];//第j件事是否被分出去
    public static int min = Integer.MAX_VALUE;//最少花费
    public static int sum = 0;//当前总花费
    public static int n;//人数

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int u) {
        //当前成本已经大于当前最小成本，则不用在遍历
        if (sum > min) return;

        //已经分配完成，不用再分配
        if (u == n) {
            min = Math.min(sum, min);
            return;
        }

        for (int j = 0; j < n; j++) {
            //
            if (!vis[j]) {
                //记录当前事件
                vis[j] = true;
                sum += cost[u][j];
                //分配下一个人
                dfs(u + 1);

                //回溯
                vis[j] = false;
                sum -= cost[u][j];
            }
        }
    }
}

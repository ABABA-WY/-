package 树与图;

import java.util.*;

public class LC743_最短路 {
    int N = 110, M = 6010;
    int n, k;

    int[][] w = new int[N][N];//邻接矩阵

    int[] he = new int[N];//邻接表
    int[] e = new int[M];//邻接表
    int[] ne = new int[M];//邻接表
    int[] w1 = new int[M];//邻接表
    int idx = 0;//邻接表

    int INF = 0x3f3f3f3f;
    boolean[] vis = new boolean[N];//是否被查询过
    int[] dist = new int[N];//距离


    public int networkDelayTime(int[][] times, int n_, int k_) {
        n = n_;
        k = k_;
        //初始化邻接矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = w[j][i] = i == j ? 0 : INF;
            }
        }
        //存图
        for (int[] c : times) {
            int x = c[0], y = c[1], u = c[2];
            w[x][y] = Math.min(w[x][y], u);
        }

        //初始化邻接表
        Arrays.fill(he, -1);
        for (int[] c : times) {
            int x = c[0], y = c[1], u = c[2];
            add(x, y, u);
        }
        int ans = 0;
        //floyd();
/*        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, w[k][i]);
        }*/
/*        dijkstra();
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }*/

       /* dijkstra();
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }*/
        spfa();
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }


//Floyd
// 时间复杂度：O(n^3)
//空间复杂度：O(n^2)
/*    public void floyd(){
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for(int p=1;p <= n; p++){
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <= n; j++) {
                    w[i][j]=Math.min(w[i][j], w[i][p]+w[p][j]);
                }
            }
        }
    }*/


//朴素 Dijkstra（邻接矩阵）
// 时间复杂度：O(n^2)
//空间复杂度：O(n^2)
/*    void dijkstra() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 迭代 n 次
        for (int i = 1; i <= n; i++) {
            int t = -1;
            // 每次找到「最短距离最小」且「未被更新」的点 t
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            // 标记点 t 为已更新
            vis[t] = true;
            // 用点 t 的「最小距离」更新其他点
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + w[t][j]);
            }
        }
    }*/


    void add(int a, int b, int c) {
        e[idx] = b;
        w1[idx] = c;//a到b的权值
        ne[idx] = he[a];
        he[a] = idx++;
    }

//堆优化版dijkstra
// 时间复杂度：O(mlogn+n)
//空间复杂度：O(m)
/*    void dijkstra() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;

        // 使用「优先队列」存储所有可用于更新的点
        // 以 (点编号, 到起点的距离) 进行存储，优先弹出「最短距离」较小的点
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        q.add(new int[]{k, 0});

        while (!q.isEmpty()) {
            // 每次从「优先队列」中弹出
            int[] poll = q.poll();
            int id = poll[0];
            int step = poll[1];
            // 如果弹出的点被标记「已更新」，则跳过
            if (vis[id]) continue;
            // 标记该点「已更新」，并使用该点更新其他点的「最短距离」
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[id] + w1[i]) {
                    dist[j] = dist[id] + w1[i];
                    q.add(new int[]{j, dist[j]});
                }
            }
        }
    }*/

//SPFA
// 时间复杂度：O(n*m)
//空间复杂度：O(m)
    void spfa() {
        // 起始先将所有的点标记为「未更新」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 使用「双端队列」存储，存储的是点编号
        Deque<Integer> d = new ArrayDeque<Integer>();
        // 将「源点/起点」进行入队，并标记「已入队」
        d.addLast(k);
        vis[k] = true;
        while (!d.isEmpty()) {
            // 每次从「双端队列」中取出，并标记「未入队」
            int poll = d.pollFirst();
            vis[poll] = false;
            // 尝试使用该点，更新其他点的最短距离
            // 如果更新的点，本身「未入队」则加入队列中，并标记「已入队」
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[poll] + w1[i]) {
                    dist[j] = dist[poll] + w1[i];
                    if (vis[j]) continue;
                    d.addLast(j);
                    vis[j] = true;
                }
            }
        }
    }
}
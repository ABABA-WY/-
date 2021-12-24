package Daly;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC407 {
    public int trapRainWater(int[][] heightMap) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dirs = {-1, 0, 1, 0, -1};
        int m = heightMap.length;
        int n = heightMap[0].length;
        int maxHeight = 0;
        int[][] water = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                water[i][j] = maxHeight;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int dx = x + dirs[i], dy = y + dirs[i + 1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                if (water[dx][dy] > water[x][y] && water[dx][dy] > heightMap[dx][dy]) {
                    water[dx][dy] = Math.max(water[x][y], heightMap[dx][dy]);
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}

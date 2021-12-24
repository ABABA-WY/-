package 树与图;

import java.util.*;

public class BFS {
    public static final int N=10010;
    public static int[][] d=new int[N][N];//距离
    public static int[][] g = new int[N][N];//棋盘
    public static int n,m;
    static List<int[]> q=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m = scanner.nextInt();
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++)
                g[i][j] = scanner.nextInt();
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        q.add(new int[]{0,0});
        for(int i=0;i<n;i++){
            Arrays.fill(d[i],-1);
        }
        d[0][0]=0;
        int hh=0;
        int[] dx={-1,0,1,0},dy={0,-1,0,1};
        while(hh< q.size()){
            int[] t=q.get(hh++);
            for(int i=0;i<4;i++){
                int x=dx[i]+t[0],y = dy[i]+t[1];
                if(x>=0&&x<n&&y>=0&&y<m&&g[x][y]==0&&d[x][y] == -1){
                    d[x][y]=d[t[0]][t[1]]+1;
                    q.add(new int[] {x,y});
                }
            }
        }
        return d[n-1][m-1];
    }

}

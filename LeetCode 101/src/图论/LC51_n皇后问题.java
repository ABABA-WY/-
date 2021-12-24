package 图论;

import java.util.*;

public class LC51_n皇后问题 {
    public int N=100;
    public int n;
    public boolean[] row=new boolean[N];//行
    public boolean[] col=new boolean[N];//列
    public boolean[] dg = new boolean[N];//正斜线
    public boolean[] udg = new boolean[N];//反斜线
    public String[][] g=new String[10][10];
    List<List<String>> res=new ArrayList<List<String>>();
    List<String> list = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    public List<List<String>> solveNQueens(int n_) {
        n = n_;
        for(int i=0;i<10;i++){
            Arrays.fill(g[i],".");
        }
        dfs(0);
        return res;
    }
/*    public void dfs(int x,int y,int s){
        if(y==n){
            y=0;
            x++;
        }
        if(x==n) {
            if (s == n) {
                list=new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    sb=new StringBuilder();

                    for (int j = 0; j < n; j++) {
                        sb.append(g[i][j]);
                    }
                    list.add(sb.toString());

                }
                res.add(list);
            }
            return;
        }
        //符合条件
        if(!row[x]&&!col[y]&&!dg[y-x+n]&&!udg[x+y]){
            //将Q加入到ans中，然后进行递归
            g[x][y]="Q";
            row[x]=col[y]=dg[y-x+n]=udg[x+y]=true;
            dfs(x,y+1,s+1);
            //恢复现场
            row[x]=col[y]=dg[y-x+n]=udg[x+y]=false;
            g[x][y]=".";
        }
        //不符合条件
        dfs(x,y+1,s);
    }*/
    //列访问
    public void dfs(int u){
        if (u == n) {
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(g[i][j]);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int i = 0;i<n; i++){
            if (!col[i] && !dg[u + i] && !udg[i - u + n]) {
                g[u][i] = "Q";
                col[i] = dg[u + i] = udg[i - u + n] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[i - u + n] = false;
                g[u][i] = "Q";
            }
        }
    }
}

package 图论;

/*
染色法就可解决
* */
public class LC785 {
    int[] color;
    int[][] graph;

    public static void main(String[] args) {
        int[][] graph_={{3,4,6},{3,6},{3,6},{0,1,2,5},{0,7,8},{3},{0,1,2,7},{4,6},{4,},{}};
        System.out.println(new LC785().isBipartite(graph_));
    }
    public boolean isBipartite(int[][] graph_) {
        int n= graph_.length;
        color=new int[n];
        graph=graph_;
        for(int i=0;i < n; i++){
            if(color[i]==0) {
                if (!dfs(i,1)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int u,int c){
        color[u]=c;
        for(int i=0;i<graph[u].length; i++){
            int j=graph[u][i];
            if(color[j]==0){
                if(!dfs(graph[u][i],3-c))
                    return false;
            }
            else if(color[j] == c)
                    return false;
        }
        return true;
    }

}

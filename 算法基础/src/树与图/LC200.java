package 树与图;

public class LC200 {
    public static void main(String[] args) {
        char[][] grid={{'1','1','1'},{'0','1','0'},{1,1,1}};
        System.out.println(new LC200().numIslands(grid));
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m= grid.length;
        int n=grid[0].length;
        int ans=0;
        for (int i=0;i<m; i++){
            for (int j = 0; j < n; j++)
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j);
                }
        }
        return ans;
    }
    public void dfs(char[][] grid,int r,int c){
        int m= grid.length;
        int n=grid[0].length;
        if(r<0||r>=m||c<0||c >= n||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}

package 排序算法;

public class LC695 {
    public static void main(String[] args) {
        int[][] grid={{0}};
        int res=new LC695().maxAreaOfIsland(grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans=Math.max(ans,AreaOfIsland(grid,i,j));
            }
        }
        return ans;
    }
    public int AreaOfIsland(int[][] grid,int i,int j){
        if(i<0||j<0||i== grid.length||j==grid[i].length||grid[i][j] == 0)
            return 0;
        return AreaOfIsland(grid, i+1, j)+AreaOfIsland(grid, i-1, j)+AreaOfIsland(grid, i, j+1)+AreaOfIsland(grid, i, j-1)+1;
    }
}

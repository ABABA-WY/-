package 模拟;

public class LC498 {
    public static void main(String[] args) {
        int[][]mat = {{1,2,3},{4,5,6},{7,8,9}};
        int [] ans=new LC498().findDiagonalOrder(mat);
        System.out.println();
    }
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int n=mat.length;
        int m=mat[0].length;
        int[] ans=new int[n*m];
        int x=0,y=0;
        int flag=1;
        int count=0;
        while (count<n*m){
            ans[count++]=mat[x][y];
            /*while(flag==1&&x >=0&&y < m){
                ans[count++]=mat[x--][y++];
            }
            if(x<0&&flag==1){
                flag=-1;
                x = 0;
                //y++;
            }
            if(y>=m&&flag==1){
                flag = -1;
                y=m-1;
                //x++;
            }
            while(flag==-1&&y>=0&&x<n){
                ans[count++]=mat[x++][y--];
            }
            if(y < 0 && flag == -1){
                flag=1;
                y=0;
                //x++;
            }
            if(x>=n&&flag==-1){
                flag=1;
                x=n-1;
                //y++;
            }*/
            if ((x + y) % 2 == 0) {
                if (y == m - 1) ++x; // 最后一列
                else if (x == 0) ++y; // 第一行
                else {--x;++y;} // 正常右上
            } else {
                if (x == n - 1) ++y;
                else if (y == 0) ++x;
                else {
                    ++x; --y;
                }
            }

        }


        return ans;
    }
}

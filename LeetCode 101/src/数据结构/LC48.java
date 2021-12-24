package 数据结构;

public class LC48 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        new LC48().rotate(matrix);
        for(int[] n:matrix){
            for (int x:n){
                System.out.print(x);
            }
            System.out.println();
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n/2; row++){
            for (int col = 0; col < (n+1) / 2; col++) {
                int temp=matrix[row][col];
                matrix[row][col]=matrix[n-1-col][row];
                matrix[n-1-col][row]=matrix[n-1-row][n-1-col];
                matrix[n-1-row][n-1-col]=matrix[col][n-1-row];
                matrix[col][n-1-row]=temp;
            }
        }
    }
}

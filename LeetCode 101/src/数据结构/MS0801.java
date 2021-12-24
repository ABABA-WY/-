package 数据结构;

public class MS0801 {

    public void setZeroes(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[m];
        for (int i = 0; i < n; i++)  {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    rows[i]=cols[j]=true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(rows[i]||cols[j]){
                    matrix[i][j]=0;
                }
            }
        }

    }
}

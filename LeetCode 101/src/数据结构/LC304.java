package 数据结构;

class NumMatrix {
    int[][] array;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        array = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i+1][j+1] = matrix[i][j]+array[i+1][j]+array[i][j+1]-array[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return array[row2+1][col2+1]-array[row1][col2+1 ]-array[row2 + 1][col1]+array[row1][col1];
    }
}

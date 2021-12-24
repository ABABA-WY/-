package Daly;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n = matrix[0].length;
        int i=m-1;
        int j=0;
        while(j<n&&i>=0){
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] > target){
                i--;
            }
            else {
                j++;
            }
        }
        return false;
    }
}

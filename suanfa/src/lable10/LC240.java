package lable10;

public class LC240 {
    public static void main(String[] args) {
        int[][] matrix= {
                {1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
        };
        int target=21;
        int m=matrix.length;
        int n=matrix[0].length;
        int i=m-1;
        int j=0;
        while(i>=0&&j<n){
            if(matrix[i][j]==target)
                return;
            else if (matrix[i][j] > target) {
                i--;
            }
            else {
                j++;
            }
        }
        return;
    }
}

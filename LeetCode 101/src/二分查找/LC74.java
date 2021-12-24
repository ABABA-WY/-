package 二分查找;

public class LC74 {
    public static void main(String[] args) {
        int[][] matrix={{1}};
        int target=1;
        System.out.println(new LC74().searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n=matrix[0].length;
        int up=0,down=m-1;
        while(up<=down){
            int mid=up+down>>1;
            if(matrix[mid][0]>target){
                down=mid-1;
            }
            else if(matrix[mid][n-1]<target){
                up = mid+1;
            }
            else{
                for (int i=0;i<n; i++) {
                    if(matrix[mid][i]== target)
                        return true;
                }
                return false;
            }
        }
        return false;
    }
}

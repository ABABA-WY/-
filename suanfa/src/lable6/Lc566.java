package lable6;

public class Lc566 {
    public static void main(String[] args) {
        int[][] nums={{1,2},{3,4}};
        Lc566 t=new Lc566();
        nums=t.matrixReshape(nums,4,4);
        for(int[]num:nums){
            for (int i:num){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if(r*c!= m*n){
            return mat;
        }
        int[][] temp=new int[r][c];
        for (int i = 0; i <m*n ; i++) {
            temp[i/c][i%c]=mat[i/n][i%n];
        }
        return temp;
    }
}


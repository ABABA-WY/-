package lable7;

public class Lc1128 {
    public static void main(String[] args) {
        int[][] dominoes={{1,2},{2,1},{1,2}};
        int[] a=new int[100];
        int count=0;
        for(int [] dominoe:dominoes){
            if (dominoe[0]>dominoe[1]){
                int temp = dominoe[0];
                dominoe[0]=dominoe[1];
                dominoe[1] = temp;
            }
            int num=dominoe[0]*10+dominoe[1];
            count+=a[num];
            a[num] ++;
        }

        System.out.println(count);
    }
}

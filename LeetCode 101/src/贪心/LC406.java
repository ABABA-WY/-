package 贪心;

import java.util.Arrays;

public class LC406 {
    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] queue=new int[people.length][people[0].length];
        Arrays.sort(people,(a,b)->Integer.compare(a[0],b[0]));

        for(int[] x:people){
            System.out.println(x[0]+"+"+x[1]);
        }
    }
}

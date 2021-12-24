package 数学;

import java.util.Scanner;

public class LC326 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(new LC326().isPowerOfThree(n));
    }
    public boolean isPowerOfThree(int n) {
        return Math.log(n)/Math.log(3)%1==0;
    }
}

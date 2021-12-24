package 数学;

import java.util.Scanner;

public class LC204 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(new LC204().countPrimes(n));
    }
    public int countPrimes(int n) {
        int count =0;
        if(n<2) return 0;
        for(int i=2;i<n;i++){
            count+=isPrime(i)?1:0;
        }
        return count;
    }
    public boolean isPrime(int i){
        for (int j=2;j*j<=i;j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}

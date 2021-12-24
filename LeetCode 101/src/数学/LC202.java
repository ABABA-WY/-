package 数学;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LC202 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        System.out.println(new LC202().isHappy(n));
    }
    private int getIndex(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> s=new HashSet<>();
        while (n!=1&&!s.contains(n)){
            s.add(n);
            n=getIndex(n);
        }
        return n==1;
    }
}

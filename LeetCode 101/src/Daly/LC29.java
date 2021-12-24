package Daly;

import java.util.Scanner;

public class LC29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend=scanner.nextInt();
        int divisor=scanner.nextInt();
        System.out.println(new LC29().divide(dividend,divisor));
    }
    public int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;
        if(divisor==1){
            return dividend;
        }
        if(divisor==-1){
            if (dividend >Integer.MIN_VALUE) {
                return -dividend;
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
        int sight=1;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor < 0)){
            sight=-1;
        }
        long a=dividend;
        long b=divisor;
        a=Math.abs(a);
        b = Math.abs(b);
        int res=div(a,b);
        res=Math.min(Integer.MAX_VALUE,res);
        return sight*res;
    }
    public int div(long a,long b){
        if(a<b) return 0;
        int count=1;
        long tb= b;
        while(tb+tb<=a){
            tb=tb + tb;
            count=count+count;
        }
        count +=div(a-tb,b);
        return count;
    }
}

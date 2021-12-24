package 数学;

import java.util.Scanner;

public class LC504 {
    public static void main(String[] args) {
        int num=new Scanner(System.in).nextInt();
        System.out.println(new LC504().convertToBase7(num));
    }
    public String convertToBase7(int num) {
        if(num==0) return "0";
        String res="";
        boolean flag=false;
        if (num<0) {
            flag = true;
            num=-num;
        }
        int d=0;
        while (num != 0) {
            d=num%7;
            num/=7;
            res=String.valueOf(d)+res;
        }
        if(flag)
            res="-"+res;
        return res;
    }
}

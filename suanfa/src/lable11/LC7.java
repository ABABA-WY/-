package lable11;

import java.util.Scanner;

public class LC7 {
    public static void main(String[] args) {
        int x=new Scanner(System.in).nextInt();
        System.out.println(new LC7().reverse(x));
    }
    public int reverse(int x) {
        int res=0;
        while(x!=0){
            if (res < Integer.MIN_VALUE / 10 ||res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res=res*10+x%10;
            x/=10;
        }
        return res;
    }
}

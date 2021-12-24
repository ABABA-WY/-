package 位运算;

import java.util.Scanner;

public class LC190 {
    public static void main(String[] args) {
        int n =new Scanner(System.in).nextInt();

    }
    public int reverseBits(int n) {
        int ans=0;
        for (int i = 0; i < 32; i++){
            ans<<=1;
            ans+=n&1;
            n>>=1;
        }
        return ans;
    }
}

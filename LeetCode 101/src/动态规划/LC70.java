package 动态规划;

import java.util.Scanner;

public class LC70 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        if(n<=2) return;
        int pre1=1;
        int pre2 = 2;
        int cur=0;
        for(int i=2;i<n;i++ ){
            cur=pre1+pre2;
            pre1=pre2;
            pre2=cur;
        }
        System.out.println(cur);
    }
}
